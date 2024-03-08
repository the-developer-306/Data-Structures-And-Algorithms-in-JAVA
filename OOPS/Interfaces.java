public class Interfaces {

    public static void main(String[] args) {

        Queen obj = new Queen();
        obj.moves();
        Rook object = new Rook();
        object.moves();

    }
    
}

interface ChessPlayer {

    void moves();
 }

class Queen implements ChessPlayer {

    public void moves() {
        System.out.println("up, down, left, right, diagonal");
     }
 }

class Rook implements ChessPlayer {

    public void moves() {
        System.out.println("up, down, left, right");
     }
 }
