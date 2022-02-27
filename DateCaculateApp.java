package dos_mode;

import java.util.Date;
import java.util.Scanner;

public class DateCaculateApp extends PublicActionProtocol{
	
	public static void SearchDate() {
		int start,end;
		long startTimeMillis,endTimeMillis,detTimeMillis;
		Scanner s=new Scanner(System.in);
		boolean loop=true;
		while(loop) {
			System.out.println("��������Ҫ��ѯ�Ŀ�ʼ���ڣ���ʽ����������6λ��8λ������ʾ���磺080101 20080101����������0�����˳�����");
			start=s.nextInt();
			int ystart,mstart,dstart;
		    if(start==0) {
		    	loop=false;
		    	System.out.println("��лʹ�ã��ټ���");
		    }
		    else if(start>0&&start<=10100) {
		    	System.out.println("�����ʽ�������������룡");
		    }
		    else if(start>=10101&&start<=991231) {
				ystart=start/10000+2000;
			    mstart=(start/100)%100;
			    dstart=start%100;
			    ResultOutput("��ʼ",ystart,mstart,dstart);
			    startTimeMillis=SearchResult(ystart, mstart, dstart);
			    System.out.println("��������Ҫ��ѯ�Ľ������ڣ���ʽ����������6λ��8λ������ʾ���磺180101 20180101����������0�����˳�����");
				end=s.nextInt();
				int yend,mend,dend;
			    if(end==0) {
			    	loop=false;
			    	System.out.println("��лʹ�����ڼ��������ټ���");
			    }
			    else if(end>0&&end<=10100) {
			    	System.out.println("�����ʽ�������������룡");
			    }
			    else if(end>=10101&&end<=991231) {
					yend=end/10000+2000;
				    mend=(end/100)%100;
				    dend=end%100;
				    ResultOutput("����",yend,mend,dend);
				    endTimeMillis=SearchResult(yend, mend, dend);
				    detTimeMillis=endTimeMillis-startTimeMillis;
				    System.out.println("��ʼ���ھ��������"+detTimeMillis/(86400*1000)+"�죬�൱�ڴ�"+dfCorrect.format((new Date().getTime()-detTimeMillis))+"����ľ���");
			    }
			    else if(end>991231&&end<1000101) {
			    	System.out.println("�����ʽ�������������룡");
			    }
			    else if(end>=1000101&&end<=99991231) {
					yend=end/10000;
				    mend=(end/100)%100;
				    dend=end%100;
				    ResultOutput("����",yend,mend,dend);
				    endTimeMillis=SearchResult(yend, mend, dend);
				    detTimeMillis=endTimeMillis-startTimeMillis;
				    System.out.println("��ʼ���ھ��������"+detTimeMillis/(86400*1000)+"�죬�൱�ڴ�"+dfCorrect.format((new Date().getTime()-detTimeMillis))+"����ľ���");
			    }
		    }
		    else if(start>991231&&start<1000101) {
		    	System.out.println("�����ʽ�������������룡");
		    }
		    else if(start>=1000101&&start<=99991231) {
		    	ystart=start/10000;
		    	mstart=(start/100)%100;
			    dstart=start%100;
			    ResultOutput("��ʼ",ystart,mstart,dstart);
			    startTimeMillis=SearchResult(ystart, mstart, dstart);
			    System.out.println("��������Ҫ��ѯ�Ľ������ڣ���ʽ����������6λ��8λ������ʾ���磺180101 20180101����������0�����˳�����");
				end=s.nextInt();
			    if(end==0) {
			    	loop=false;
			    	System.out.println("��лʹ�ã��ټ���");
			    }
			    else if(end>0&&end<=10100) {
			    	System.out.println("�����ʽ�������������룡");
			    }
			    else if(end>=10101&&end<=991231) {
			    	int yend,mend,dend;
					yend=end/10000+2000;
				    mend=(end/100)%100;
				    dend=end%100;
				    ResultOutput("����",yend,mend,dend);
				    endTimeMillis=SearchResult(yend, mend, dend);
				    detTimeMillis=endTimeMillis-startTimeMillis;
				    System.out.println("��ʼ���ھ��������"+detTimeMillis/(86400*1000)+"�죬�൱�ڴ�"+dfCorrect.format((new Date().getTime()-detTimeMillis))+"����ľ���");
		    }
			    else if(end>=1000101&&end<=99991231){
			    	int yend,mend,dend;
					yend=end/10000;
				    mend=(end/100)%100;
				    dend=end%100;
				    ResultOutput("����",yend,mend,dend);
				    endTimeMillis=SearchResult(yend, mend, dend);
				    detTimeMillis=endTimeMillis-startTimeMillis;
				    System.out.println("��ʼ���ھ��������"+detTimeMillis/(86400*1000)+"�죬�൱�ڴ�"+dfCorrect.format((new Date().getTime()-detTimeMillis))+"����ľ���");
			    }
		    }
			    else {
			    	System.out.println("��֧�ֲ�ѯ��Ԫ10000���Ժ�����Ŷ~����������");
			    }
		}
	}
	public static void ResultOutput(String status,int y,int m,int d) {
//		Scanner s=new Scanner(System.in);
		if(!ValidDate(y, m, d)) {
			System.out.println("�������ڲ����ڣ���Ҫ��������ǲ��ǣ�"+dfCorrect.format(SearchResult(y,m,d))+"��");
			System.out.println(status+"���ڣ�"+dfCorrect.format(SearchResult(y,m,d)));
		}
		else {
			System.out.println(status+"���ڣ�"+dfCorrect.format(SearchResult(y,m,d)));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--------------------------------------------");
		System.out.println("��ӭ�������ڼ�������");
		PrintCurrentTime();
		SearchDate();
	}

}
