package dos_mode;

import java.text.ParseException;
import java.util.Date;

public class PublicActionProtocol extends DateFormatProtocol{
	//输出当前时间
	public static void PrintCurrentTime() {
        System.out.println(dfNow.format(new Date()));
        System.out.println("--------------------------------------------");
	}
	//搜索日期转化为对应的时间戳
	public static long SearchResult(int y,int m,int d) {
	    String searchTime = y+" "+m+" "+d;
	    Date searchResult =null;
	    //日期字符串转化为时间戳
	    try {
	    	searchResult = dfSearch.parse(searchTime);
	        } catch (ParseException e) {
	        	e.printStackTrace();
	    	        }
	    return searchResult.getTime();
	    }
}
