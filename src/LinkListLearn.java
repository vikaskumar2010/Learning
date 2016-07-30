import java.util.ArrayList;
import java.util.List;

public class LinkListLearn {

    public static void main(String[] args) {
        //Node<Integer> n1 = new Node<Integer>(1);
        List<Node<Integer>> lst = new ArrayList<Node<Integer>>();
        for (int i = 0; i < 10; i++) {
            Node<Integer> n1 = new Node<Integer>(i);
            lst.add(n1);
        }
        for (int i = 0; i < lst.size() - 1; i++) {
            lst.get(i).next = lst.get(i + 1);
        }
        Node<Integer> start = lst.get(0);

        LinkListLearn l = new LinkListLearn();

        l.printLinkList(start);

        start = l.reverseRecursively(start);
        System.out.println();
        l.printLinkList(start);
    }

    public <T> void printLinkList(Node<T> start) {
        Node<T> s = start;
        while (s != null) {
            System.out.print(s + "  ");
            s = s.next;
        }
    }

    public <T> Node<T> reverseRecursively(Node<T> start) {
        if (start == null || start.next == null) {
            return start;
        } else {
            Node<T> y = reverseRecursively(start.next);
            start.next.next = start;
            start.next = null;
            return y;
        }

    }

}

class Node<T> {
    public T       data;
    public Node<T> next;

    public Node(T d) {
        data = d;
        next = null;
    }

    public Node(T d, Node<T> n) {
        data = d;
        next = n;
    }

    public String toString() {
        return "[" + data + "]";
    }
}
