package dos_mode;
import java.util.Date;
import java.util.Scanner;

//����ʱ�䣬���㵱ǰʱ��������ʱ��ľ���
public class TimerCaculateApp extends PublicActionProtocol{
	public static void ResultOutput(int y,int m,int d) {
		long searchTimeSec=SearchResult(y,m,d);
		long detTimeSec=nowTimeSec-searchTimeSec;
		long halfdet=(nowTimeSec+searchTimeSec)/2;
		long doubledet=nowTimeSec-2*detTimeSec;
		Date halfdate=new Date(halfdet);
	    Date onedate=new Date(searchTimeSec);
	    Date doubledate=new Date(doubledet);
	    
	    System.out.println("--------------------------------------------");
	    System.out.println(dfNow.format(new Date()));/*�����ǰʱ��*/
	    if(!ValidDate(y,m,d)) {
	    	System.out.println("�������ڲ����ڣ���Ҫ��������ǲ��ǣ�"+dfCorrect.format(onedate)+"��");
	    }
		if(detTimeSec>0)/*������ʱ��Ϊ��ȥʱ*/ {
			System.out.println("�� "+dfResult.format(onedate)+" �ѹ� ");
			System.out.println(detTimeSec/(86400*1000)+" �� "+(detTimeSec%(86400*1000))/(3600*1000)+" ʱ "+(detTimeSec%(3600*1000))/(60*1000)+" �� "+(detTimeSec%(60*1000))/1000+" ��");
	    }else {/*������ʱ��Ϊ����ʱ*/
	    	System.out.println("�� "+dfResult.format(onedate)+" ʣ�� ");
	    	System.out.println(Math.abs(detTimeSec)/(86400*1000)+" �� "+(Math.abs(detTimeSec)%(86400*1000))/(3600*1000)+" ʱ "+(Math.abs(detTimeSec)%(3600*1000))/(60*1000)+" �� "+(Math.abs(detTimeSec)%(60*1000))/1000+" ��");
	    }
	    //���ȫ�����
	    System.out.println("--------------------------------------------");
	    System.out.println("���0.5��ʱ�����ʱ��Ϊ��");
	    System.out.println(dfResult.format(halfdate));
	    System.out.println("���2��ʱ�����ʱ��Ϊ��");
	    System.out.println(dfResult.format(doubledate));

	    System.out.println("--------------------------------------------");
	}
	public static void SearchDate() {
		boolean loop=true;
        Scanner s=new Scanner(System.in);
        while(loop) {
	      //����Ҫ��ѯ��ʱ���
			System.out.println("��������Ҫ��ѯ�����ڣ���ʽ����������6λ��8λ������ʾ���磺080101 20080101����������0�����˳�����");
		    int date=s.nextInt();
		    int y,m,d;
		    if(date==0) {
//		    	System.out.println(0);
		    	loop=false;
		    	System.out.println("��лʹ�õ���ʱ���������ټ���");
		    }
		    else if(date>0&&date<=10100) {
		    	System.out.println("�����ʽ�������������룡");
//		    	System.out.println(1);
		    }
		    else if(date>=10101&&date<=991231) {
				y=date/10000+2000;
			    m=(date/100)%100;
			    d=date%100;
				//ʱ������㲢����
				ResultOutput(y,m,d);
//		    	System.out.println(2);
		    }
		    else if(date>991231&&date<1000101) {
//		    	System.out.println(3);
		    	System.out.println("�����ʽ�������������룡");
		    }
		    else if(date>=1000101&&date<=99991231) {
		    	y=date/10000;
		    	m=(date/100)%100;
			    d=date%100;
			    
				//ʱ������㲢����
				ResultOutput(y,m,d);
//		    	System.out.println(4);
				}
		    else {
		    	System.out.println("��֧�ֲ�ѯ��Ԫ10000���Ժ�����Ŷ~");
//		    	System.out.println(5);
		    }
        }
        
	}
    

public static void main(String[] args) {
	System.out.println("--------------------------------------------");
	System.out.println("��ӭ��������ʱ��������");
	PrintCurrentTime();
	SearchDate();
}
}
