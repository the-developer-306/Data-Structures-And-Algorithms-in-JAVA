public class UseOfStatic {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.schoolName = "MHS";
        // now schoolName is defined for all objects of Student class 
        Student s2 = new Student();
        System.out.println(s2.schoolName);
     }
    
}

class Student {
    String name;
    
    String schoolName; // put static here

    void setName(String name) {
        this.name = name;
     }
    String getName() {
        return this.name;
     } 

 }