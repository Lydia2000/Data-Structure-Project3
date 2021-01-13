import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import javax.net.ssl.SSLHandshakeException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class URLCatcher {
	private String urlStr;
    private String content;
    public static ArrayList<String> urllist=new ArrayList<String>();
    
    public URLCatcher(String urlStr){
    	this.urlStr = urlStr;
    }
    
    

    private String fetchContent() throws IOException{
  		URL url = new URL(this.urlStr);
  		URLConnection conn = url.openConnection();
  		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");
  		
  		InputStream in = conn.getInputStream();
  		
		InputStreamReader inReader = new InputStreamReader(in,"utf-8");
  		BufferedReader br = new BufferedReader(inReader);
  	
  		String retVal = "";
  	
  		String line = null;
  		
  		while ((line = br.readLine()) != null){
  		    retVal = retVal + line + "\n";
  		}
  	
  		return retVal;
      }
    public ArrayList<String> match() throws IOException{	
    	try {
		if(content==null){
		    content = fetchContent();
		}	
		urllist.clear();
		Document doc = Jsoup.parse(content);
		Elements lis = doc.select("div");
		// System.out.println(lis);
	//	 lis = lis.select(".kCrYT");
			// System.out.println(lis.size());
			
			
			for(Element li : lis)
			{ 
				try {
//					
					String citeUrl = li.select("a").get(0).attr("href");
				//	String title = li.select("a").get(0).select(".vvjwJb").text();
					//System.out.println(title + ","+citeUrl);
					
					if(citeUrl.contains("javascript:")||citeUrl.contains("#accesskey")||citeUrl==""
							||citeUrl.contains("feebee")||citeUrl.contains("biggo")||citeUrl.contains("findprice")
							||citeUrl.length()<10||citeUrl.contains(".pdf")||citeUrl.contains(".doc")||citeUrl.contains("wikipedia")||citeUrl.contains("https://www.books.com.tw/web/")||urllist.size()>3||urllist.contains(citeUrl)){}
					else
					{urllist.add(citeUrl);}
					

		}catch (IndexOutOfBoundsException e) {

//			e.printStackTrace(); 

		}
		
	}}
    	catch(Exception e) {
    	//	System.out.println(e.getStackTrace());
    	}
			
			urllist.add(urlStr);
		    return urllist;
}

  

    	
}