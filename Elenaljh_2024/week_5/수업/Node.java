package 수업;

public class Node<T> {

    public T data;
    public Node<T> link;

    public Node() {
    }

    public Node(T data, Node<T> link) {
        this.data = data;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", link=" + link +
                '}';
    }
}
