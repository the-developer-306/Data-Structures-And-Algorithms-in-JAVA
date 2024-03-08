import java.util.*;

public class firstNonRepeatingLetter {

    static void  printFirstNonRepeating(String str) {

        int freq[] = new int[26]; // to store the frequency of letters occuring in the string.
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++; // ch-'a' results in the index of character ch in freq array.
            
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove(); // remove all occurrences of repeated characters from queue.
            }

            if (!q.isEmpty()) {
                System.out.print(q.peek() + ", ");
            }
            else {
                System.out.print(-1 + ", ");
            }
        }

    }

    public static void main(String[] args) {
        String str = "aabccxb";
        printFirstNonRepeating(str);
    }
}