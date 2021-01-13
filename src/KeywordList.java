import java.util.LinkedList;

public class KeywordList {
	
	
	private LinkedList<Keyword> lst;
	
	public KeywordList(){
		this.lst = new LinkedList<Keyword>();
	}
	
	public void add(Keyword keyword){
		lst.add(keyword);
	}
		
	public void outputScore(){
		float results = 0;
		for(int i=0;i<lst.size();i++){
		    Keyword k = lst.get(i);
		    results += k.weight * k.count;
		}
		
		System.out.println(results);
		}
	public String getName(int i) {
		String name =  lst.get(i).name;
		return name;
	}
	public int getWeight(int i) {
		int weight =  lst.get(i).weight;
		return weight;
	}
	
	
	public int size() {
		int size = lst.size();
		return size;
	}
}