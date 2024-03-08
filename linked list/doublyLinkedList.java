public class doublyLinkedList {
    
    public static class Node {
        int val;
        Node next;      //self refrencing variable
        Node prev;      //self refrencing variable

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int  size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        newNode.prev = null;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        newNode.next = null;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }
        else if (size == 1) {
            int data = head.val;
            head = tail = null;
            return data;
        }

        int data = head.val;
        head = head.next;
        head.prev = null;
        size--;
        return data;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }
        else if (size == 1) {
            int data = tail.val;
            head = tail = null;
            return data;
        }

        int  data = tail.val;
        tail = tail.prev;
        tail.next = null;
        size--;
        return data;
    }

    public void reverseList() {

        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        tail = head;
        head = prev;
    }

    void printList() { 

        // base case
        if (head == null) { 
            System.out.println("linked list is empty");
            return;
        }    

        Node temp = head;
        while(temp != null) { 
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    void reversePrintList() { 

        // base case
        if (tail == null) { 
            System.out.println("linked list is empty");
            return;
        }    

        Node temp = tail;
        while(temp != null) { 
            System.out.print(temp.val + " --> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        doublyLinkedList dl = new doublyLinkedList();
        dl.addFirst(10);
        dl.addFirst(20);
        dl.addFirst(40);
        dl.addFirst(60);
        dl.addLast(80);
        dl.removeFirst();
        dl.removeLast();
        
        System.out.println("The doubly linked list is:");
        dl.printList();

        System.out.println("Reversing the doubly linked list...");
        dl.reversePrintList();

        dl.reverseList();

        System.out.println("The doubly linked list is:");
        dl.printList();

        System.out.println("Reversing the doubly linked list...");
        dl.reversePrintList();

    }


}
