package 수업;

import java.util.EmptyStackException;

public class SsafyStack<E> implements IStack<E> {

    private Node<E> top;
    @Override
    public void push(E e) {
        top = new Node<E>(e, top);
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        Node<E> popNode = top;
        top = popNode.link;
        popNode.link = null;
        return popNode.data;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
