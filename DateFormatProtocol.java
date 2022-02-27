package dos_mode;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateFormatProtocol{
	//��ȡ��ǰʱ���
	static long nowTimeSec=(long)System.currentTimeMillis();
	//ʱ���ʾ��ʽ
    static SimpleDateFormat dfNow= new SimpleDateFormat("��ǰʱ���� yyyy �� MM �� dd �� E HH ʱ mm �� ss ��");
    static SimpleDateFormat dfResult= new SimpleDateFormat("yyyy �� MM �� dd �� HH ʱ mm �� ss ��");
    static SimpleDateFormat dfSearch= new SimpleDateFormat("yyyy MM dd");
    static SimpleDateFormat dfCorrect= new SimpleDateFormat("yyyy �� MM �� dd ��");
    //�����Ƿ��׼
    static boolean ValidDate(int y,int m,int d) {
    	if(m<1||m>12||d<1||d>31)return false;
   		if((m==4||m==6||m==9||m==11)&&d==31)return false;
    	if(m==2) {
    		if(d>29)return false;
    		if(y%4!=0&&d>28)return false;
    		else if(y%100==0&&y%400!=0&&d>28)return false;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	int y,m,d;
    	Scanner s=new Scanner(System.in);
    	for(int i=0;i<3;i++) {
    	y=s.nextInt();
    	m=s.nextInt();
    	d=s.nextInt();
    	System.out.println(y+" "+m+" "+d);
		System.out.println(ValidDate(y,m,d));
    	}
    	s.close();
	}
}
