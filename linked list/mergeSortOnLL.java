public class mergeSortOnLL {

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
        fast = head.next;   // this is done so that the slow pointer only reaches the end of first half node

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = (fast.next).next;
        }
        return slow;
    }

    public Node merge(Node newLeftHead, Node newRightHead) {

        // creating a new linked list
        Node mergedLL = new Node(-1);
        Node curr = mergedLL;

        while (newLeftHead != null && newRightHead != null) {
            if (newLeftHead.val <= newRightHead.val) {
                curr.next = newLeftHead;
                newLeftHead = newLeftHead.next;
                curr = curr.next;
            }
            else {
                curr.next = newRightHead;
                newRightHead = newRightHead.next;
                curr = curr.next;
            }
        }

        while (newLeftHead != null) {
            curr.next = newLeftHead;
            newLeftHead = newLeftHead.next;
            curr = curr.next;
        }

        while (newRightHead != null) {
            curr.next = newRightHead;
            newRightHead = newRightHead.next;
            curr = curr.next;
        }

        return mergedLL.next;   // the first node containing -1 is removed
    }

    public Node mergeSort(Node head) {

        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // step1- find middle element and break the linked list into two halves
        Node mid = findMidNode(head);
        Node rightHead = mid.next;
        mid.next = null;

        // step2- Recursion for left and right linked lists
        Node newLeftHead = mergeSort(head);
        Node newRightHead = mergeSort(rightHead);

        // step3- merge the two halves
        return  merge(newLeftHead, newRightHead);

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
        mergeSortOnLL llist = new mergeSortOnLL();
        /* Create following Linked List:  
        7 -> 5 -> 8 -> 9 -> 6 -> 4 */
        llist.addFirst(9);
        llist.addFirst(4);
        llist.addFirst(2);
        llist.addFirst(6);
        llist.addFirst(56);
        llist.addFirst(13);

        llist.printList();

        System.out.println("\nNow printing sorted list:");

        head = llist.mergeSort(head);

        llist.printList();
    }
}
