public class Abstraction {

    public static void main(String[] args) {
        Horse obj = new Horse();
        obj.eat();
        obj.walk();
        System.out.println(obj.skinColor);
        obj.changeColor();                  //changes the skinColor
        System.out.println(obj.skinColor);

        Penguin ob = new Penguin();
        ob.eat();
        ob.walk();
     }
    
}

abstract class Animal {

    String skinColor;

    Animal() {   //this is called just as the object of derived class is made
        skinColor = "brown";
     }
    
    void eat() {
        System.out.println("eats anything");
    }

    abstract void walk(); 
    // here we have written a function which is not implemented here i.e. 
    // we have hidden the unnessecery details
}

class Horse extends Animal {

    void changeColor() {
        skinColor = "dark brown";
     }

    void walk() {
        System.out.println("walks on 4 legs");
     }
 }

 class Penguin extends Animal {

    void walk() {
        System.out.println("walks on 2 legs");
     }
 }