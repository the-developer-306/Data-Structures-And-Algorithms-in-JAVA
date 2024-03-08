import java.util.Stack;
public class stackUsingJCF {
    
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println("peeked element is: " + s.peek());

        System.out.println("poped element is: " + s.pop());

        System.out.println("peeked element is: " + s.peek());
    }
}
