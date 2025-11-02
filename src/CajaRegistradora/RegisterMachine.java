package CajaRegistradora;

public class RegisterMachine {
    double amount;

    public synchronized void charge(double amount){
        this.amount += amount;
    }

    public double getTotal() {
        return this.amount;
    }
}
