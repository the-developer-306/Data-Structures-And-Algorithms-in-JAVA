public class removeDuplicates {

    static void remDup(String str, int pos, StringBuilder newStr, Boolean map[]) {

        if (pos == str.length()) {
            System.out.println(newStr);
            return;
        }

        int currChar = str.charAt(pos);

        if (map[currChar - 'a'] == true) {
            //duplicate case
            remDup(str, pos+1, newStr, map);
        } else { 
            map[currChar - 'a'] = true;
            remDup(str, pos+1, newStr.append(currChar), map);
        }
    }

   public static void main(String[] args) {
        remDup("appnnacollege", 0, new StringBuilder(""), new Boolean[26]);
   }
}
