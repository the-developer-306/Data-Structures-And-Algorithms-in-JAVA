import java.util.ArrayList;
import java.util.Collections;

public class basicsOfArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(1);
        list.add(2);
        list.add(3);
    
        int size = list.size();
        System.out.println("Size of the arraylist: " + size);

        System.out.println("The arraylist is empty : " + list.isEmpty()); 

        Integer element = list.get(0);
        System.out.println("Element at index 0: " + element);

        list.remove(1);

        list.set(1, 10);

        System.out.println("The arraylist contains 10 : " + list.contains(10));

        list.add(1, 46);

        System.out.println("unsorted arraylist : " + list);

        Collections.sort(list);

        System.out.println("unsorted arraylist : " + list);


    }
}
