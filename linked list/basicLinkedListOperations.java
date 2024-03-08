public class basicLinkedListOperations {

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

    void addLast(int data) { 
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;

        tail = newNode;
    }

    void addMiddle(int index, int data) {

        //special case of adding ata first
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        int i = 0;
        Node curr = head;
        while (i<index-1) {
            curr = curr.next;
            i++;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }

    int removeFirst() {
        if (size == 0) {
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        } 
        else if (size ==  1) {  
            int data = head.val;
            head = null;
            tail = null;
            size--;
            return data;
        }

        int data = head.val;
        head = head.next;
        size--;
        return data;
    }

    int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } 
        else if(size == 1) {
            int data = head.val;
            head = tail = null;
            size--;
            return data;
        }

        //now traversing to the second last pointer
        Node secondLast = head;
        int i = 0;
        while(i < (size-1)-1) {
            secondLast = secondLast.next;
            i++;
        }
        int data = tail.val;
        tail = secondLast;
        secondLast.next = null;
        size--;
        return data;
    }

    void searchElement(int key) {       // Iterative approach with time O(n)
        Node curr = head;
        int i = 0;
        while (curr != null) {
            if(curr.val == key) {
                System.out.println("Key found at " + i);
                return;
            }
            curr = curr.next;
            i++;
        }
    }

    int searchElement(Node head, int  key) {
        //base case
        if(head == null) {  
            return Integer.MIN_VALUE;
        }

        if (head.val == key) {
            return key;
        }

        int  res = searchElement(head.next, key);     //recursive call

        if (res == Integer.MIN_VALUE) {
            System.out.println("Key not found");
            return Integer.MIN_VALUE;
        }
        
            System.out.println("Key found");
            return key;
        
    }

    void reverseList() {    //iterative approach
        Node prev = null;
        Node curr = tail = head;    // java provides left to right assignment
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // after this loop the prev will be pointing 
        //to the last element of the original list

        head = prev;

    }

    void deleteNthNodeFromEnd(int n) {

        if (n == size) {
            head = head.next;
            size--;
            return;
        }
        // nth node from end will be (size-n+1)th node from start
        Node curr = head;
        int i = 1;
        while (i < (size-n+1)-1) {
            curr = curr.next;
            i++;
        }
        curr.next = (curr.next).next;
        size--;
    }

    // using turtle-hare(slow-fast) pointer approach
    Node findMidNode(Node head) {
        slow = head;
        fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = (fast.next).next;
        }
        return slow;
    }

    boolean checkPalindrome(Node head) {
        
        //base case (if linked list has only one or no element)
        if (head == null || head.next == null) {
            return true;
        }

        // step1 - find middle node
        Node midNode = findMidNode(head);

        // step2 - reverse the second half linked list
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node firstHalfHead = head;
        Node reverseSecondHalfHead = prev;

        // step3 - comparing the respective elements of both half linked lists
        Node curr1 = firstHalfHead;
        Node curr2 = reverseSecondHalfHead;

        while (curr2 != null) {
            if (curr1.val != curr2.val) {
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return true;
    }

    void makingALoopInLL() {
        Node curr = head;
        for (int i = 1; i < size; i++) {
            curr = curr.next;
            i++;
        }
        curr.next = head.next;      //adding a loop in the linked list
    }

    boolean detectLoop() {      //floyd's cycle detecting algorithm

        //base case
        if (head == null || head.next == null) {
            return false;
        }

        slow = head;
        fast = head;

        while (fast == null || fast.next != null) {
            slow = slow.next;
            fast = (fast.next).next;
            
            if (slow == fast) {
                return true;   //loop detected
            }
        }
        return false;           //no loop found
    }

    void removeLoop() {
        
        // step1 - detect loop
        boolean isLooped = detectLoop();

        /*step2 -  if no loop, return as there is nothing to be done or if there is loop then 
        re-initialise the slow pointer to head and then move both slow and fast pointers at same pace until
        they meet again which will be the node where we need to break the loop from. Also keep a track of prev of
        fast and then make its next as null.*/
        Node prev = null;
        if (isLooped) {
            slow = head;
            //as fast is a global variable thus it holds the same position where detectLoop() placed it.
            while(slow != fast) {
                slow = slow.next;
                prev = fast;
                fast = fast.next;
            }
            prev.next = null;
            System.out.println("Loop successfully removed");
        }
        else {
            System.out.println("No Loop Found");
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

        basicLinkedListOperations llist = new basicLinkedListOperations();

        llist.addFirst(1);
        llist.addFirst(2);
        llist.addFirst(3);

        llist.addLast(0);
        llist.addMiddle(0, 4);
        llist.printList();
        System.out.println(size);

        llist.removeFirst();
        llist.printList();
        System.out.println(size);

        llist.removeLast();
        llist.printList();
        System.out.println(size);

        llist.searchElement(head, 2);

        llist.reverseList();
        llist.printList();
        
        llist.deleteNthNodeFromEnd(3);
        llist.printList();

        llist.addFirst(2);
        llist.addFirst(3);
        llist.printList();

        System.out.println(llist.checkPalindrome(head));
        
        llist.makingALoopInLL();
        System.out.println("Loop found: " + llist.detectLoop());

        llist.removeLoop();
        System.out.println("Loop found: " + llist.detectLoop());
    }
}