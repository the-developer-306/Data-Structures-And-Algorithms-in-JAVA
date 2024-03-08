public class InheritanceApplication {

    public static void main(String[] args) {
        fish obj = new fish();
        obj.finSize = 10;
        System.out.println(obj.finSize);
        obj.eat();
        obj.breathe();
        obj.swim();
    }
    
}
class Animals {

    void eat(){
        System.out.println("eats food");
    }

    void breathe() {
        System.out.println("breathes in air");
     } 

}
class fish extends Animals {
    int finSize;

    void swim() {
        System.out.println("swims in water");
     }
}
