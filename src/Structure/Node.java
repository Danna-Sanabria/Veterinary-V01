package Structure;

public class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;
    private Node<T> father;
    private int balanceFactor;

    public Node(T data, Node<T> father) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.father = father;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return this.right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getFather() {
        return father;
    }

    public void setFather(Node<T> father) {
        this.father = father;
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }
}

