public class Keyword {
	public String name;
    public int count;
    public int weight;
    
    public Keyword(String name,int weight){
		this.name = name;
		//this.count =count;
		this.weight =weight;
    }
    //test
  /* public int getCount()
    {
    	return this.count;
    }*/
    public String getName() 
    {
    	return this.name;
    }
    public int getWeight() 
    {
    	return this.weight;
    }
    
    @Override
    public String toString(){
    	return "["+name+","+count+","+weight+"]";
    }
}