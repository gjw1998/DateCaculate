package dos_mode;
import java.util.Date;
import java.util.Scanner;

//输入时间，计算当前时间与输入时间的距离
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
	    System.out.println(dfNow.format(new Date()));/*输出当前时间*/
	    if(!ValidDate(y,m,d)) {
	    	System.out.println("输入日期不存在！您要查的日期是不是："+dfCorrect.format(onedate)+"？");
	    }
		if(detTimeSec>0)/*若输入时间为过去时*/ {
			System.out.println("距 "+dfResult.format(onedate)+" 已过 ");
			System.out.println(detTimeSec/(86400*1000)+" 天 "+(detTimeSec%(86400*1000))/(3600*1000)+" 时 "+(detTimeSec%(3600*1000))/(60*1000)+" 分 "+(detTimeSec%(60*1000))/1000+" 秒");
	    }else {/*若输入时间为将来时*/
	    	System.out.println("距 "+dfResult.format(onedate)+" 剩余 ");
	    	System.out.println(Math.abs(detTimeSec)/(86400*1000)+" 天 "+(Math.abs(detTimeSec)%(86400*1000))/(3600*1000)+" 时 "+(Math.abs(detTimeSec)%(3600*1000))/(60*1000)+" 分 "+(Math.abs(detTimeSec)%(60*1000))/1000+" 秒");
	    }
	    //输出全部结果
	    System.out.println("--------------------------------------------");
	    System.out.println("距今0.5倍时间轴的时间为：");
	    System.out.println(dfResult.format(halfdate));
	    System.out.println("距今2倍时间轴的时间为：");
	    System.out.println(dfResult.format(doubledate));

	    System.out.println("--------------------------------------------");
	}
	public static void SearchDate() {
		boolean loop=true;
        Scanner s=new Scanner(System.in);
        while(loop) {
	      //输入要查询的时间戳
			System.out.println("请输入您要查询的日期（格式：年月日用6位或8位整数表示，如：080101 20080101）（若输入0，则退出程序）");
		    int date=s.nextInt();
		    int y,m,d;
		    if(date==0) {
//		    	System.out.println(0);
		    	loop=false;
		    	System.out.println("感谢使用倒计时计算器，再见！");
		    }
		    else if(date>0&&date<=10100) {
		    	System.out.println("输入格式有误，请重新输入！");
//		    	System.out.println(1);
		    }
		    else if(date>=10101&&date<=991231) {
				y=date/10000+2000;
			    m=(date/100)%100;
			    d=date%100;
				//时间轴计算并反馈
				ResultOutput(y,m,d);
//		    	System.out.println(2);
		    }
		    else if(date>991231&&date<1000101) {
//		    	System.out.println(3);
		    	System.out.println("输入格式有误，请重新输入！");
		    }
		    else if(date>=1000101&&date<=99991231) {
		    	y=date/10000;
		    	m=(date/100)%100;
			    d=date%100;
			    
				//时间轴计算并反馈
				ResultOutput(y,m,d);
//		    	System.out.println(4);
				}
		    else {
		    	System.out.println("不支持查询公元10000年以后的年代哦~");
//		    	System.out.println(5);
		    }
        }
        
	}
    

public static void main(String[] args) {
	System.out.println("--------------------------------------------");
	System.out.println("欢迎来到倒计时计算器！");
	PrintCurrentTime();
	SearchDate();
}
}
