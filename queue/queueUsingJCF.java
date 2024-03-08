import java.util.*;
public class queueUsingJCF {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("Queue after adding elements: " + q);
    }
}
