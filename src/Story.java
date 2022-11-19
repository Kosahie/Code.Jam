
public class Story {

	private Node start;
	private String title;
	
	public void read() {
		
		System.out.print("Now starting: " + title);
		
		start.readNode();
		
	}
	
	public Node getStart() {
		return start;
	}
	public void setStart(Node start) {
		this.start = start;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
