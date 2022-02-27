package dos_mode;

import java.text.ParseException;
import java.util.Date;

public class PublicActionProtocol extends DateFormatProtocol{
	//�����ǰʱ��
	public static void PrintCurrentTime() {
        System.out.println(dfNow.format(new Date()));
        System.out.println("--------------------------------------------");
	}
	//��������ת��Ϊ��Ӧ��ʱ���
	public static long SearchResult(int y,int m,int d) {
	    String searchTime = y+" "+m+" "+d;
	    Date searchResult =null;
	    //�����ַ���ת��Ϊʱ���
	    try {
	    	searchResult = dfSearch.parse(searchTime);
	        } catch (ParseException e) {
	        	e.printStackTrace();
	    	        }
	    return searchResult.getTime();
	    }
}
