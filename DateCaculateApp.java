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
			System.out.println("请输入您要查询的开始日期（格式：年月日用6位或8位整数表示，如：080101 20080101）（若输入0，则退出程序）");
			start=s.nextInt();
			int ystart,mstart,dstart;
		    if(start==0) {
		    	loop=false;
		    	System.out.println("感谢使用，再见！");
		    }
		    else if(start>0&&start<=10100) {
		    	System.out.println("输入格式有误，请重新输入！");
		    }
		    else if(start>=10101&&start<=991231) {
				ystart=start/10000+2000;
			    mstart=(start/100)%100;
			    dstart=start%100;
			    ResultOutput("开始",ystart,mstart,dstart);
			    startTimeMillis=SearchResult(ystart, mstart, dstart);
			    System.out.println("请输入您要查询的结束日期（格式：年月日用6位或8位整数表示，如：180101 20180101）（若输入0，则退出程序）");
				end=s.nextInt();
				int yend,mend,dend;
			    if(end==0) {
			    	loop=false;
			    	System.out.println("感谢使用日期计算器，再见！");
			    }
			    else if(end>0&&end<=10100) {
			    	System.out.println("输入格式有误，请重新输入！");
			    }
			    else if(end>=10101&&end<=991231) {
					yend=end/10000+2000;
				    mend=(end/100)%100;
				    dend=end%100;
				    ResultOutput("结束",yend,mend,dend);
				    endTimeMillis=SearchResult(yend, mend, dend);
				    detTimeMillis=endTimeMillis-startTimeMillis;
				    System.out.println("开始日期距结束日期"+detTimeMillis/(86400*1000)+"天，相当于从"+dfCorrect.format((new Date().getTime()-detTimeMillis))+"至今的距离");
			    }
			    else if(end>991231&&end<1000101) {
			    	System.out.println("输入格式有误，请重新输入！");
			    }
			    else if(end>=1000101&&end<=99991231) {
					yend=end/10000;
				    mend=(end/100)%100;
				    dend=end%100;
				    ResultOutput("结束",yend,mend,dend);
				    endTimeMillis=SearchResult(yend, mend, dend);
				    detTimeMillis=endTimeMillis-startTimeMillis;
				    System.out.println("开始日期距结束日期"+detTimeMillis/(86400*1000)+"天，相当于从"+dfCorrect.format((new Date().getTime()-detTimeMillis))+"至今的距离");
			    }
		    }
		    else if(start>991231&&start<1000101) {
		    	System.out.println("输入格式有误，请重新输入！");
		    }
		    else if(start>=1000101&&start<=99991231) {
		    	ystart=start/10000;
		    	mstart=(start/100)%100;
			    dstart=start%100;
			    ResultOutput("开始",ystart,mstart,dstart);
			    startTimeMillis=SearchResult(ystart, mstart, dstart);
			    System.out.println("请输入您要查询的结束日期（格式：年月日用6位或8位整数表示，如：180101 20180101）（若输入0，则退出程序）");
				end=s.nextInt();
			    if(end==0) {
			    	loop=false;
			    	System.out.println("感谢使用，再见！");
			    }
			    else if(end>0&&end<=10100) {
			    	System.out.println("输入格式有误，请重新输入！");
			    }
			    else if(end>=10101&&end<=991231) {
			    	int yend,mend,dend;
					yend=end/10000+2000;
				    mend=(end/100)%100;
				    dend=end%100;
				    ResultOutput("结束",yend,mend,dend);
				    endTimeMillis=SearchResult(yend, mend, dend);
				    detTimeMillis=endTimeMillis-startTimeMillis;
				    System.out.println("开始日期距结束日期"+detTimeMillis/(86400*1000)+"天，相当于从"+dfCorrect.format((new Date().getTime()-detTimeMillis))+"至今的距离");
		    }
			    else if(end>=1000101&&end<=99991231){
			    	int yend,mend,dend;
					yend=end/10000;
				    mend=(end/100)%100;
				    dend=end%100;
				    ResultOutput("结束",yend,mend,dend);
				    endTimeMillis=SearchResult(yend, mend, dend);
				    detTimeMillis=endTimeMillis-startTimeMillis;
				    System.out.println("开始日期距结束日期"+detTimeMillis/(86400*1000)+"天，相当于从"+dfCorrect.format((new Date().getTime()-detTimeMillis))+"至今的距离");
			    }
		    }
			    else {
			    	System.out.println("不支持查询公元10000年以后的年代哦~请重新输入");
			    }
		}
	}
	public static void ResultOutput(String status,int y,int m,int d) {
//		Scanner s=new Scanner(System.in);
		if(!ValidDate(y, m, d)) {
			System.out.println("输入日期不存在！您要查的日期是不是："+dfCorrect.format(SearchResult(y,m,d))+"？");
			System.out.println(status+"日期："+dfCorrect.format(SearchResult(y,m,d)));
		}
		else {
			System.out.println(status+"日期："+dfCorrect.format(SearchResult(y,m,d)));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--------------------------------------------");
		System.out.println("欢迎来到日期计算器！");
		PrintCurrentTime();
		SearchDate();
	}

}
