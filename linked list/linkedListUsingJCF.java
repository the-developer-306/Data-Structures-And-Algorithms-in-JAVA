import java.util.LinkedList;
public class linkedListUsingJCF {
    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList<>();
        
        // Adding elements to the list
        llist.add(5);
        llist.addFirst(4);
        llist.addFirst(3);
        llist.addFirst(2);
        llist.addFirst(1);
        llist.addFirst(0);

        System.out.println(llist);

        llist.removeFirst();
        llist.removeLast();

        System.out.println(llist);
    }
}
