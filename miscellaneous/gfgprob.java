import java.util.*;
class gfgprob {
    public static void main(String[] args)  {
        String str = "((iy)rc(uv()(z((e())))u)()(()(())(e)((qb)(v((i))((pv))bw(uu)bg)))m()(l)(()(k)q)()(((n(n)))j)(";
        
        ArrayList<Integer> list = new ArrayList<>();
        int oc = 0;
        int cc = 0;
        int temp = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') {
                list.add(++oc);
                temp = oc;
            }

            if (str.charAt(i) == ')') {
                cc = temp;
                list.add(cc--);
            }
        }
        System.out.println(list);
    }
};