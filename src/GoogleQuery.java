import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.net.URL;

import java.net.URLConnection;

import java.util.HashMap;



import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;



public class GoogleQuery 

{

	public String searchKeyword2;

	public String url;

	public String content;

	public GoogleQuery(String searchKeyword)

	{
		if(searchKeyword.contains(" ")) {
		this.searchKeyword2 = searchKeyword.replaceAll(" ", "+");}
		else {
			this.searchKeyword2 = searchKeyword;
		}
		
			System.out.println("空格得思"+searchKeyword);
		

		this.url = "http://www.google.com/search?q="+searchKeyword2+"&oe=utf8&num=13";

	}

	

	private String fetchContent() throws IOException

	{
		String retVal = "";

		URL u = new URL(url);

		URLConnection conn = u.openConnection();

		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");

		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in,"utf-8");

		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while((line=bufReader.readLine())!=null)
		{
			retVal += line;

		}
		return retVal;
	}
	public HashMap<String, String> query() throws IOException

	{

		if(content==null)

		{

			content= fetchContent();

		}

		HashMap<String, String> retVal = new HashMap<String, String>();
		
		Document doc = Jsoup.parse(content);
		//System.out.println(doc.text());
		Elements lis = doc.select("div");
		// System.out.println(lis);
		lis = lis.select(".kCrYT");
		// System.out.println(lis.size());
		
		
		for(Element li : lis)
		{
			try 

			{
				String citeUrl = li.select("a").get(0).attr("href");
				String title = li.select("a").get(0).select(".vvjwJb").text();
				String citeUrl2="https://www.google.com"+citeUrl;
				if(citeUrl.contains("feebee")||citeUrl.contains("biggo")||citeUrl.contains("findprice")||citeUrl.contains("eslite")||citeUrl.contains("findprice")||citeUrl.contains("kobo")
						||citeUrl.contains("pixnet")	||citeUrl.contains("wikipedia")||citeUrl.contains("youtube")||citeUrl.contains("facebook")||citeUrl2.contains("https://www.google.comhttp://www.google.com/search?")||citeUrl.contains("https://www.google.com/search?")||citeUrl.length()<10){}
				else
				{retVal.put(title, citeUrl2);}

			} catch (IndexOutOfBoundsException e) {

//				e.printStackTrace();

			}

			

		}

		

		return retVal;

	}

	

	

}