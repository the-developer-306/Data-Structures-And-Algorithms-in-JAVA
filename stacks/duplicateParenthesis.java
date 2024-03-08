import java.util.Stack;
public class duplicateParenthesis {

    static boolean checkValidParenthesis(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
           
            char currChar = str.charAt(i);

            if (currChar == ')') {
                int count = 0;
                while (stack.peek() != '(') {
                    stack.pop();
                    count++;
                }
                if (count == 0) {
                    return true;
                }
                else {
                    stack.pop();
                }
            }
            else {
                stack.push(currChar);
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        String parenthesis = "((a+b)+(c+d))" ;

        boolean validity = checkValidParenthesis(parenthesis);

        System.out.println("Do duplicates exist in the given parenthesis string: " + validity);
    }
}
