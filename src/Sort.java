import java.io.IOException;
import java.util.ArrayList; 
import java.util.Collections;
import java.util.Iterator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//import javax.swing.text.html.HTMLDocument.Iterator; 
public class Sort { 
	static ArrayList<Website> arrayStudent = new ArrayList<>();
	String rec="";
	 public  HashMap sort(ArrayList<String>name,ArrayList<String>url,ArrayList<Integer>score) throws IOException { 
	
		  for(int i=0;i<url.size();i++) {
			  if(url.get(i).contains("https://www.taaze.tw/rwd_searchResult.html?keyType%5B%5D=1&keyword%5B%5D=")) {
				  url.get(i).replaceAll("https://www.taaze.tw/rwd_searchResult.html?keyType%5B%5D=1&keyword%5B%5D=你好","https://www.taaze.tw/rwd_searchResult.html?keyType%5B%5D=1&keyword%5B%5D=");
			  }
		   arrayStudent.add(new Website(name.get(i),url.get(i),score.get(i)));

		  }
		  
		  Collections.sort(arrayStudent);
		  
		  HashMap hmp = new LinkedHashMap();
			for(int i =0; i<arrayStudent.size();i++) {
				//String scoreStr=Integer.toString(arrayStudent.get(i).getScore());
				hmp.put(arrayStudent.get(i).getName(),arrayStudent.get(i).getUrl());
			}
			
			int i = 0;
			Iterator iter = hmp.entrySet().iterator();
		    while (iter.hasNext()) {
		      i++;
	           Map.Entry entry = (Map.Entry) iter.next();
	           Object key = entry.getKey();
	           Object val = entry.getValue();
	         //  System.out.println("Name="+entry.getKey()+"  "+"  Url="+entry.getValue()); 
		  
		  
		 }
		    
		    System.out.println(hmp);
		    arrayStudent.clear();
			return hmp;}
	 }
