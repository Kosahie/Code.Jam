import java.util.ArrayList;
import java.util.List;

public class Action {

    private String body;
    private Node node;
    private List<String> identifiers;

    public List<String> getIdentifiers() {
		return identifiers;
	}

	public void setIdentifiers(List<String> identifiers) {
		this.identifiers = identifiers;
	}
	
	public void addIdentifier(String id) {
		this.identifiers.add(id);
	}
	
	public void removeIdentifier(String id) {
		this.identifiers.remove(id);
	}

	public Action(String body, Node node) {
        this.body = body;
        this.node = node;
    	this.identifiers = new ArrayList<>();
        this.identifiers.add(body);
    }
    
	public Action(String body, Node node, List<String> identifiers) {
        this.body = body;
        this.node = node;
    	this.identifiers = new ArrayList<>();
    	for (String i : identifiers) this.addIdentifier(i);
        this.addIdentifier(body);
    }
	
    public Action() {
		// TODO Auto-generated constructor stub
    	this.identifiers = new ArrayList<>();
	}

	public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
    
    @Override
    public String toString() {
    	return this.getBody();
    }
}