package dos_mode;

import java.util.Scanner;

public class MainApp extends PublicActionProtocol{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c;
		boolean loopMain=true;
		PrintCurrentTime();
		System.out.println("欢迎来到我的计算器！");
		Scanner s=new Scanner(System.in);
		while(loopMain) {
		System.out.println("输入1进入倒计时计算器 输入2进入日期计算器 输入0退出程序");
		c=s.nextInt();
		if(c==0) {
			System.out.println("感谢使用，再见！");
			loopMain=false;
		}
		else if(c==1)
			TimerCaculateApp.main(args);
		else if(c==2)
			DateCaculateApp.main(args);
		else
			System.out.println("输入错误,请重新输入");
			
		}
		s.close();
	}
}
