import java.util.*;
public class interleaveTwoHalves {

    static void interleave(Queue<Integer> q) {

        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size(); 
        // we have calculated size coz in the loop test statement we are using the q.remove() method,
        // which constatntly changes the size of the q.

        for (int i = 0; i < size/2; i++) {
            firstHalf.add(q.peek());
            q.remove();
        }

        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 1; i <= 10; i++) {
            q.add(i);
        }
       
        interleave(q);

        while (!q.isEmpty()) {
            System.out.print(q.remove() + ", ");
        }
    }
}
