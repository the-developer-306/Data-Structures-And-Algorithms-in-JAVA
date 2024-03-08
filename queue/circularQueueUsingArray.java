public class circularQueueUsingArray {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        static boolean isEmpty() {

            if(rear == -1 && front == -1){
                return true;
            }
            return false;
        }

        static boolean isFull() {

            if((rear+1)%size == front){
                return true;
            }
            return false;
        }

        public static void add(int data) {
            
            if(!isFull()) {

                rear = (rear+1)%size;
                arr[rear] = data;

                //condition for adding element in empty queue
                if (front == -1) {
                    front = (front+1)%size;
                }
            }
            else {
                System.out.println("Queue id full");
                return;
            }
        }

        public static int remove() {

            if (!isEmpty()) {
                
                int val = arr[front];
                
                //condition fr deletion of last element 
                if (front == rear) {
                    front = rear = -1;
                }
                else {
                    front = (front+1)%size;
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
                
                int val = arr[front];
                return val;
            }
            else {
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
        }

    }
    
    public static void main(String[] args) {
        
        Queue q = new Queue(5);
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
