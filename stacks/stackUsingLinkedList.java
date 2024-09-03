public class stackUsingLinkedList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static class Stack {

        static Node head = null;

        static boolean isEmpty() {
            return head == null;
        }

        static void push(int data) {

            Node newNode = new Node(data);
            
            //we know that usig linked list, the head is the stack top
            if (isEmpty()) {
                head = newNode;
                return;
            } 

            newNode.next = head;
            head = newNode;
        }

        static int pop() {

            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }

            int data = head.val;
            head = head.next;
            return data;
        }

        static int peek() {
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return head.val;
        }

        static void printStack() {
            if (isEmpty()) {
                System.out.println("Stack UnderFlow");
                return;
            }

            Node curr = head;
            while(curr != null) {
                System.out.println(curr.val);
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println("peeked element is: " + s.peek());

        System.out.println("poped element is: " + s.pop());

        s.printStack();
    }
}
