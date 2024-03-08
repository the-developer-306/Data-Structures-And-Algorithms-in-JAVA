public class queueUsingLL {
    
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {

        static Node head = null;
        static Node tail = null;

        static boolean isEmpty() {

            if(head == null && tail == null){
                return true;
            }
            return false;
        }

        public static void add(int data) {
            
            Node newNode = new Node(data);

            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public static int remove() {

            if (!isEmpty()) {
                int val = head.data;
                if (head == tail) {
                    head = tail = null;
                } else {
                    head = head.next;
                }
                return val;
            }
            else {
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
        }

        public static int peek() {

            if (!isEmpty()) {
                
                return head.data;
            }
            else {
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue();
        
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
