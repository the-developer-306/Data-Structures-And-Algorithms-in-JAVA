import java.util.*;

public class stackUsingTwoQueues {

    static class Stack {

        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();



        static void add(int data) {

            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }

            q1.add(data);

            while (!q2.isEmpty()) {
                q1.add(q2.remove());
            }
        }

        static int remove() {

            if (!q1.isEmpty()) {
                return q1.remove();
            }

            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }

        static int peek() {

            if (!q1.isEmpty()) {
                return q1.peek();
            }

            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }

        static void printStack() {
            while (!q1.isEmpty()) {
                System.out.println(remove());
            }
        }

    }

    public static void main(String[] args) {

        Stack s = new Stack();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);

        s.printStack();        
    }
}
