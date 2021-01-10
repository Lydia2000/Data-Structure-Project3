import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class KeywordCounter2 {
	private String urlStr;
    private String content;
    
    public KeywordCounter2(String urlStr){
    	this.urlStr = urlStr;
    }
    
    private String fetchContent() throws IOException{
    	
    	String retVal = "";
    	
		URL url = new URL(this.urlStr);

		URLConnection conn = url.openConnection();
    			

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
    
    public int countKeyword(String keyword) throws IOException{
		if (content == null){
		    content = fetchContent();
		}
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();
	
		int retVal = 0; 
		
		int pos = content.indexOf(keyword);
		while(pos != -1)
		{
			retVal++;
			pos = content.indexOf(keyword,pos+1); 
		}
	
		return retVal;
    }
    
    KeywordList kLst = new KeywordList();	
    public int returnScore() throws IOException {
    	File file = new File("keywordInput.txt");
		Scanner sc = new Scanner(file);
		
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
		//	sc.close();
		}
	
		
    
			int total = 0;
		 

			try {
			for(int i=0;i<kLst.size();i++){
				String d = kLst.getName(i); 
				int w = kLst.getWeight(i);
				//System.out.println(d+"="+counter.countKeyword(d));
				//System.out.println(urlStr);
				//System.out.println(d+"="+countKeyword(d)+" "+countKeyword(d)*w);				
				total+=countKeyword(d)*w;}	}			
				 
			    catch(IOException e) {
			    	total =0;
			    }


		//		System.out.println(total);
			
		

		return total;
    
		}
   
  
}


