package dos_mode;

import java.util.Scanner;

public class MainApp extends PublicActionProtocol{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c;
		boolean loopMain=true;
		PrintCurrentTime();
		System.out.println("��ӭ�����ҵļ�������");
		Scanner s=new Scanner(System.in);
		while(loopMain) {
		System.out.println("����1���뵹��ʱ������ ����2�������ڼ����� ����0�˳�����");
		c=s.nextInt();
		if(c==0) {
			System.out.println("��лʹ�ã��ټ���");
			loopMain=false;
		}
		else if(c==1)
			TimerCaculateApp.main(args);
		else if(c==2)
			DateCaculateApp.main(args);
		else
			System.out.println("�������,����������");
			
		}
		s.close();
	}
}
