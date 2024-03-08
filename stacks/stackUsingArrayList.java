import java.util.ArrayList;
public class stackUsingArrayList {
    
    public static class Stack {

        static ArrayList<Integer> list = new ArrayList<>();

        //isEmpty
        static boolean isEmpty() {
            return list.size() == 0;
        }

        //push
        static void push(int data) {
            list.add(data);
        }

        //pop
        static int pop() {
            if(!isEmpty()) {
                int data = list.get(list.size()-1);
                list.remove(list.size()-1);
                return data;
            }
            return Integer.MIN_VALUE;
        }

        //peek
        static int peek() {
            if(!isEmpty()) {
                return list.get(list.size()-1);
            }
            return Integer.MIN_VALUE;
        }

        //print stack 
        static void printStack() {
            if(!isEmpty()) {
                
                while (isEmpty() == false) {
                    System.out.println(peek());
                    pop();
                }
            } 
            else {
                System.out.println("Stack Underflow");
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
