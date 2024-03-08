import java.util.Stack;
public class queueUsingTwoStacks {

    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();



        static void add(int data) {

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        static int remove() {

            if (!s1.isEmpty()) {
                return s1.pop();
            }

            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }

        static int peek() {

            if (!s1.isEmpty()) {
                return s1.peek();
            }

            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }

        static void printQueue() {
            while (!s1.isEmpty()) {
                System.out.println(remove());
            }
        }

    }

    public static void main(String[] args) {

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        q.printQueue();        
    }
}
