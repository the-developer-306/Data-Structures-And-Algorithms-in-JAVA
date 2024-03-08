public class AbstractionConstructor {

    public static void main(String[] args) {
        
        Penguin obj = new Penguin();
        obj.c = 10;
    }
    
}

abstract class Animal {

    Animal() {   
        System.out.println("Animal constructor called");
    }
}

class Horse extends Animal {

    Horse() {
        System.out.println("Horse constructor called");
     }
}

class Penguin extends Horse {

    int c;

    Penguin() {
        System.out.println("Penguin constructor called");
     }

    
}