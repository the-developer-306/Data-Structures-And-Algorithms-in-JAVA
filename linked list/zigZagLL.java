public class zigZagLL {

    public static class Node {
        int val;
        Node next;  // self refrencing variable

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;
    public static Node slow;
    public static Node fast;

    void addFirst(int data) {
        // step 1: creation of a new Node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        // step 2: pointing the next of newNode to head
        newNode.next = head;
        // step 3: make newNode as the new head
        head = newNode;
    }

    public Node findMidNode(Node head) {
        slow = head;
        fast = head.next;   
        // this is done so that the slow pointer only reaches the end of first half node

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = (fast.next).next;
        }
        return slow;
    }

    public void makeZigZag() {

        //step1- find middle node
        Node  midNode = findMidNode(head);

        //step2- reverse the second half linked list
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //step3- connect two halves
        Node lHead = head;
        Node rHead = prev;
        Node nextL, nextR;
        while (lHead != null && rHead != null) {
            nextL = lHead.next;
            lHead.next = rHead;
            nextR = rHead.next;
            rHead.next = nextL;

            rHead = nextR;
            lHead = nextL;
        }
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

    public static void main(String[] args) {
        zigZagLL llist = new zigZagLL();
        /* Create following Linked List:  
        7 -> 5 -> 8 -> 9 -> 6 -> 4 */
        llist.addFirst(1);
        llist.addFirst(2);
        llist.addFirst(3);
        llist.addFirst(4);
        llist.addFirst(5);
        llist.addFirst(6);

        llist.printList();

        System.out.println("\nNow printing zig-zag list:");

        llist.makeZigZag();

        llist.printList();
    }
}
