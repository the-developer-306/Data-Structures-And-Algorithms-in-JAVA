import java.util.Stack;
public class pushAtBottom {

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
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        //now task is to push 4 at the bottom of the stack
        bottomPush(stack, 4);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
