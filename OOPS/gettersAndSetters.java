public class gettersAndSetters {
    
    public static void main(String[] args) {

        BankAcc obj = new BankAcc();
        obj.setBalance(5000);
        obj.userName = "Pratham Khanna";
        int bal = obj.getBalance();
        String user = obj.getUserName();

        System.out.println(bal); 
        System.out.println(user);
        
     }

}

class BankAcc {

    private int balance;
    String userName;

    void setName(String name) {     //setters
        userName = name;
    }
    void setBalance(int balance) {      //setters
        this.balance = balance;
    }
    int getBalance() {      //getters
        return balance;
    }
    String getUserName() {      //getters
        return userName;
     }

}