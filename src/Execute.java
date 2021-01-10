import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.net.ssl.SSLHandshakeException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Execute {
	String keyword="";
	String rec="";
	public HashMap main(String args) throws IOException,SSLHandshakeException {
		keyword=args;
		File file = new File("keywordInput.txt");
		Scanner sc = new Scanner(file);
		KeywordList kLst = new KeywordList();
		ArrayList<String> googleList=new ArrayList<String>();
		ArrayList<String> nameList=new ArrayList<String>();
		HashMap<String, String> result=new HashMap<String, String>();

	HashMap<String, String> query=new GoogleQuery(keyword).query();
	for(Entry<String, String> entry : query.entrySet()) {
	    String key = entry.getKey(); //key存名字
	    String value = entry.getValue(); //value存網址
	    googleList.add(value);
	    nameList.add(key);
	    }
	ArrayList<String> resultURL=new ArrayList<String>();
	ArrayList<String> resultName=new ArrayList<String>();

		ArrayList<Integer> resultScore=new ArrayList<Integer>();
		
		int googlelistSize=googleList.size();
   	for(int  s=0; s<googlelistSize;s++) {
   			String googleName=nameList.get(s);
			String googleurl = googleList.get(s);
			if(googleurl.contains("https://www.books.com.tw/products/"))
					{
			
					resultURL.add("相關搜尋"+"_______"+new Recommend(googleurl).query());

				resultName.add("\n");
				resultScore.add(-10000);
					}
		

			System.out.println("搜尋結果: "+googleurl);

			ArrayList<String> url=new ArrayList<String>();
		try {	
			URLCatcher hm = new URLCatcher(googleurl);
	url=hm.match();
	
}
			
	 catch(SSLHandshakeException e) 
		{
		 System.out.println("SSLHandshakeException!!!");
		System.out.println(googleurl);
	
		continue;}
		
		while(sc.hasNext()){
		    String cmd = sc.next();
		    switch(cmd){
	        	case "add":
	        	{
	        		String name = sc.next();
	        		int weight = sc.nextInt();
	        		Keyword k = new Keyword(name, weight);
	        		kLst.add(k);
	        		
	        	}
	        		break;
	        			        	
        	    default:
        	    	System.out.println("InvalidOperation2");       	    	      
		    }
		}
		System.out.println("子網頁有"+url.size());

		int score=0;
		int webscore=0;
		for(int x=0;x<url.size();x++) {

		    	KeywordCounter2 counter = new KeywordCounter2(url.get(x));  

			score=	counter.returnScore();
		if(webscore<300)
		{webscore=webscore+score;}

		}
		
		
		resultURL.add(googleurl);
		resultName.add(googleName);
	    System.out.println("分數: "+webscore);
	    resultScore.add(webscore);	
   }	
   	
		resultURL.add("https://www.eslite.com/Search?manufacturer=&author=&stock=&retail_price=&manufacturer_date=&sort=&size=20&start=0&status=&categories=&keyword="+keyword);
	  resultURL.add("https://www.taaze.tw/rwd_searchResult.html?keyType%5B%5D=1&keyword%5B%5D="+keyword);
		resultScore.add(100);
		resultScore.add(100);

		resultName.add(keyword+"-誠品");
		resultName.add(keyword+"-讀冊");

    Sort sort=new Sort();
    result.clear();
   result=sort.sort(resultName,resultURL, resultScore);
   resultName.clear();
   resultURL.clear();
   resultScore.clear();
 // System.out.println("結果"+result); 
    sc.close();

	return result;

    

	
	}
	}