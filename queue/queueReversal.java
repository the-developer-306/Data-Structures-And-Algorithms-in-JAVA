import java.util.*;
public class queueReversal {
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= 10; i++) {
            q.add(i);
        }

        Stack<Integer> s = new Stack<>();

        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        // reversing queue elements
        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        while (!q.isEmpty()) {
            System.out.print(q.remove() + ", ");
        }
    }
}
