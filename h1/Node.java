package h1;

public class Node {

    private Node next;

    public Node(Node next) {
        this.next = next;
    }

    public static int distance(Node x, Node y) {
        if (x==null || y==null)
            return -1;
        if (x==y)
            return 0;
        Node bufferNode = y;
        int nodeDistance = 0;
        while(bufferNode!=null) {
            nodeDistance++;
            bufferNode = bufferNode.getNext();
            if (bufferNode==x)
                return nodeDistance;
        }
        return -1;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
