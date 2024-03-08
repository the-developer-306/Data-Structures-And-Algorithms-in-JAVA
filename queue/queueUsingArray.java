public class queueUsingArray {

    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        static boolean isEmpty() {

            if(rear == -1){
                return true;
            }
            return false;
        }

        static boolean isFull() {

            if(rear == size-1){
                return true;
            }
            return false;
        }

        public static void add(int data) {
            
            if(!isFull()) {

                rear++;
                arr[rear] = data;
            }
            else {
                System.out.println("Queue id full");
                return;
            }
        }

        public static int remove() {

            if (!isEmpty()) {
                
                int val = arr[0];

                //now move each elemrnt of the array to 1 step backwards
                for (int i = 0; i < rear; i++) {
                    arr[i] = arr[i+1];
                }
                rear--;
                return val;
            }
            else {
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
        }

        public static int peek() {

            if (!isEmpty()) {
                
                int val = arr[0];
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