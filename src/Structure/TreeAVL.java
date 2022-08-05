package Structure;

import java.util.ArrayList;
import java.util.Comparator;

public class TreeAVL<T> {
    public static final String MESSAGE_DATA_NOT_FOUND = "EL DATO NO EXISTE";
    public static final String MESSAGE_TREE_EMPTY = "NO HAY DATOS PARA MOSTRAR";
    public static final String MESSAGE_DATA_EXIST = "EL DATO YA EXISTE";
    private Node<T> root;
    private final Comparator<T> comparator;

    public TreeAVL(Comparator<T> comparator) {
        root = null;
        this.comparator = comparator;
    }

    public void insert(T d) throws Exception {
        if (root == null)
            root = new Node<>(d, null);
        else {
            Node<T> n = root;
            Node<T> father;
            while (true) {
                if (comparator.compare(d, n.getData()) == 0)
                    throw new Exception(MESSAGE_DATA_EXIST);
                father = n;
                boolean direction = comparator.compare(n.getData(), d) > 0;
                n = direction ? n.getLeft() : n.getRight();
                if (n == null) {
                    if (direction)
                        father.setLeft(new Node<>(d, father));
                    else
                        father.setRight(new Node<>(d, father));
                    reBalance(father);
                    break;
                }
            }
        }
    }

    public void remove(T dataRemove) throws Exception {
        if (root == null)
            throw new Exception(MESSAGE_TREE_EMPTY);
        Node<T> n = root;
        Node<T> father = root;
        Node<T> nodeDelete = null;
        Node<T> son = root;
        while (son != null) {
            father = n;
            n = son;
            son = comparator.compare(dataRemove, n.getData()) >= 0 ? n.getRight() : n.getLeft();
            if (comparator.compare(dataRemove, n.getData()) == 0)
                nodeDelete = n;
        }
        if (nodeDelete != null) {
            nodeDelete.setData(n.getData());
            son = n.getLeft() != null ? n.getLeft() : n.getRight();
            if (comparator.compare(dataRemove, root.getData()) == 0)
                root = son;
            else {
                if (father.getLeft() == n)
                    father.setLeft(son);
                else
                    father.setRight(son);

                reBalance(father);
            }
        } else {
            throw new Exception(MESSAGE_DATA_NOT_FOUND);
        }
    }

    private void reBalance(Node<T> n) {
        setBalance(n);
        if (n.getBalanceFactor() == -2) {
            if (getHeightMax(n.getLeft().getLeft()) >= getHeightMax(n.getLeft().getRight()))
                n = rotationRR(n);
            else
                n = rotationLR(n);
        } else if (n.getBalanceFactor() == 2) {
            if (getHeightMax(n.getRight().getRight()) >= getHeightMax(n.getRight().getLeft()))
                n = rotationLL(n);
            else
                n = rotationRL(n);
        }
        if (n.getFather() != null)
            reBalance(n.getFather());
        else
            root = n;
    }

    private Node<T> rotationLL(Node<T> n) {
        Node<T> b = n.getRight();
        b.setFather(n.getFather());
        n.setRight(b.getLeft());
        b.setLeft(n);
        n.setFather(b);
        if (b.getFather() != null) {
            if (b.getFather().getRight() == n)
                b.getFather().setRight(b);
            else
                b.getFather().setLeft(b);
        }
        setBalance(n, b);
        return b;
    }

    private Node<T> rotationRR(Node<T> n) {
        Node<T> b = n.getLeft();
        b.setFather(n.getFather());
        n.setLeft(b.getRight());

        if (n.getLeft() != null)
            n.getLeft().setFather(n);

        b.setRight(n);
        n.setFather(b);

        if (b.getFather() != null) {
            if (b.getFather().getRight() == n)
                b.getFather().setRight(b);
            else
                b.getFather().setLeft(b);
        }
        setBalance(n, b);
        return b;
    }

    private Node<T> rotationLR(Node<T> n) {
        n.setLeft(rotationLL(n.getLeft()));
        return rotationRR(n);
    }

    private Node<T> rotationRL(Node<T> n) {
        n.setRight(rotationRR(n.getRight()));
        return rotationLL(n);
    }

    private int getHeightMax(Node<T> n) {
        if (n == null)
            return -1;
        return 1 + Math.max(getHeightMax(n.getLeft()), getHeightMax(n.getRight()));
    }

    @SafeVarargs
    private void setBalance(Node<T>... nodes) {
        for (Node<T> n : nodes)
            n.setBalanceFactor(getHeightMax(n.getRight()) - getHeightMax(n.getLeft()));
    }



    public String preOrder() {
        StringBuilder phrase = new StringBuilder();
        preOrder(root, 0, phrase);
        return phrase.toString();
    }

    private void preOrder(Node<T> node, int level, StringBuilder phrase) {
        if (node != null) {
            phrase.append(node.getData()).append("(").append(level).append(") - ");
            preOrder(node.getRight(), level + 1, phrase);
            preOrder(node.getLeft(), level + 1, phrase);
        }
    }

    public ArrayList<T> getListData(){
        ArrayList<T> phrase = new ArrayList<>();
        getListData(root, phrase);
        return phrase;
    }

    public void getListData(Node<T> node, ArrayList<T> phrase){
        if (node != null) {
            inOrder(node.getLeft(), phrase);
            phrase.add(node.getData());
            inOrder(node.getRight(), phrase);
        }
    }

    public ArrayList<T> inOrder() {
        ArrayList<T> phrase = new ArrayList<>();
        inOrder(root, phrase);
        return phrase;
    }

    private void inOrder(Node<T> node, ArrayList<T> phrase) {
        if (node != null) {
            inOrder(node.getLeft(), phrase);
            phrase.add(node.getData());
            inOrder(node.getRight(), phrase);
        }
    }

    public String postOrder() {
        StringBuilder phrase = new StringBuilder();
        postOrder(root, 0, phrase);
        return phrase.toString();
    }

    private void postOrder(Node<T> node, int level, StringBuilder phrase) {
        if (node != null) {
            postOrder(node.getLeft(), level + 1, phrase);
            postOrder(node.getRight(), level + 1, phrase);
            phrase.append(node.getData()).append(" - ");
        }
    }

    public T exist(T data) throws Exception {
        Node<T> temp = exist(root, data);
        if (temp != null) {
            return temp.getData();
        }
        throw new Exception(MESSAGE_DATA_NOT_FOUND);
    }

    public Node<T> exist(Node<T> node, T value) {
        if (comparator.compare(value, node.getData()) == 0)
            return node;
        else if (comparator.compare(value, node.getData()) > 0)
            if (node.getRight() == null)
                return null;
            else
                return exist(node.getRight(), value);
        else if (node.getLeft() == null)
            return null;
        else
            return exist(node.getLeft(), value);
    }

    public T firstElement() {
        if (root != null) {
            Node<T> node = root;
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
            return node.getData();
        }
        return null;
    }

    public T lastElement() {
        if (root != null) {
            Node<T> node = root;
            while (node.getRight() != null) {
                node = node.getRight();
            }
            return node.getData();
        }
        return null;
    }

    public int countNodes() {
        return countNodes(root);
    }

    public int countNodes(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }

    public Node<T> getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }
}

