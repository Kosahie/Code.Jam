
public class Action {

    private String body;
    private Node node;

    public Action(String body, Node node) {
        this.body = body;
        this.node = node;
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
}