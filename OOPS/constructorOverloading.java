import java.util.Scanner;
public class constructorOverloading {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int marks = sc.nextInt();


        //This is an example of Polymorphism

        Student obj1 = new Student();
        Student obj2 = new Student(name);
        Student obj3 = new Student(marks);
        sc.close();
        // obj1.close();
        // obj2.close();
        // obj3.close();
        obj1.a = 10;
        obj2.a = 10;
        obj3.a = 10;

    }
    
}
class Student {

    String name;
    int marks;
    int a;

    Student() {
        System.out.println("Nothing much");
    }

    Student(String name) {
        this.name = name;
        System.out.println("Name is: " + this.name);
    } 
    Student(int marks) {
        this.marks = marks;
        System.out.println("Marks are: " + this.marks);
    }

 }