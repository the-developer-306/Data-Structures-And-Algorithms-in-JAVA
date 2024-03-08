import java.util.Stack;
public class reverseStackElements {

    static void bottomPush(Stack<Integer> s, int data) {

        //base case
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        bottomPush(s, data);
        s.push(top);
    }

    static void reverseStack(Stack<Integer> s){

        //base case
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        bottomPush(s, top);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        reverseStack(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    
}
