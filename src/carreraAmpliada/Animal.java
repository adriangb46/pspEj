package carreraAmpliada;

import java.util.concurrent.Semaphore;
public abstract class Animal extends Thread{
    String name;
    private Semaphore s;

    private int distance;

    public Animal(String name, Semaphore s) {
        this.name = name;
        this.s = s;
        distance = 0;
    }

    public abstract int getVelocity(boolean wind);

}
