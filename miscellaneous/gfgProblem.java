public class gfgProblem {
    public static class Node {
        int data;
        Node next;  // self refrencing variable

        Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    public static int size;
    public static Node head;
    public static Node end;

    void addLast(int data) { 
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            end = newNode;
            return;
        }

        end.next = newNode;

        end = newNode;
    }

    void segregate() {
        
        //make a pointer reach the end
        Node tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }
        
        // searching for 0's
        Node prev = head;
        Node curr = head.next;
        while(curr.next != null) {
            if(head.data == 0) {
                tail.next = head;
                head = head.next;
                tail = tail.next;
                tail.next = null;
                prev = head;
                curr = head.next;
            }
            else if(curr.data == 0) {
                tail.next = curr;
                curr = curr.next;
                tail = tail.next;
                tail.next = null;
                prev.next = curr;
            }
            else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        
        //searching for 1's
        prev = head;
        curr = head.next;
        while(curr.next != null) {
            if(head.data == 1) {
                tail.next = head;
                head = head.next;
                tail = tail.next;
                tail.next = null;
                prev = head;
                curr = head.next;
            }
            else if(curr.data == 1) {
                tail.next = curr;
                curr = curr.next;
                tail = tail.next;
                tail.next = null;
                prev.next = curr;
            }
            else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        
        //searching for 2's
        prev = head;
        curr = head.next;
        while(curr.next != null) {
            if(head.data == 1) {
                tail.next = head;
                head = head.next;
                tail = tail.next;
                tail.next = null;
                prev = head;
                curr = head.next;
            }
            else if(curr.data == 1) {
                tail.next = curr;
                curr = curr.next;
                tail = tail.next;
                tail.next = null;
                prev.next = curr;
            }
            else {
                prev = prev.next;
                curr = curr.next;
            }
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
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        gfgProblem llist = new gfgProblem();

        

        llist.addLast(1);
        llist.addLast(2);
        llist.addLast(2);
        llist.addLast(1);
        llist.addLast(2);llist.addLast(0);llist.addLast(2);llist.addLast(2);
                
        llist.segregate();

        llist.printList();
    }
}
