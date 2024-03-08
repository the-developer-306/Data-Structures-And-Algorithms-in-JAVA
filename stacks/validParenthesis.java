import java.util.Stack;
public class validParenthesis {

    static boolean checkValidParenthesis(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
           
            char bracket = str.charAt(i);

            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } 
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (bracket == ')' && stack.peek() == '('  || 
                    bracket == '}' && stack.peek() == '{'  || 
                    bracket == ']' && stack.peek() == '[' )     {

                    stack.pop();
                } 
                else {
                    return false;
                }
            }  
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        String parenthesis = "({[]}())(((({[]}))))" ;

        boolean validity = checkValidParenthesis(parenthesis);

        System.out.println("The validity of given parenthesis string: " + validity);
    }
}
