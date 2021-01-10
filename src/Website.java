public class Website implements Comparable<Website> {
	public String name;
	public int score;
	public String url;
	
	@Override
	public int compareTo(Website website) {
		int compareQuantity = website.getScore();
		return compareQuantity-this.score;
	}
	Website(String name,String url,int score){
		this.name = name;
		this.score = score;
		this.url=url;
	}
	
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}
	public int getScore() {
		return score;
	}
}
