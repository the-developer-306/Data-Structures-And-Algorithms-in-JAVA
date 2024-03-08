public class MethodOverriding {

    public static void main(String[] args) {
        Lion obj = new Lion();
        obj.eat();
    }
    
}
class Animal {

    void eat() {
        System.out.println("eats anything");

    }
 }

class Lion {
    // priority is given to this eat()
    void eat() {
        System.out.println("eats meat");
    }
 }