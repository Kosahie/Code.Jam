import java.util.List;

public class Node{

    private String body;
    private List<Action> action;

    public Node(String body, List<Action> action) {
        this.body = body;
        this.action = action;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Action> getAction() {
        return action;
    }

    public void setAction(List<Action> action) {
        this.action = action;
    }
}