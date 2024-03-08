public class StringCompression {
    public static void main(String[] args) { 
        String str = "aaaabbbccd";
        Integer count = 1;
        String st = "";

        for(int i = 0; i < str.length(); i++) { 
            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) { 
                count++;
                i++;
            }
            st = st + str.charAt(i);

            if (count > 1) { 
                st = st + count.toString();
            }
            count = 1;
        }
        System.out.println(st);
    }
}
