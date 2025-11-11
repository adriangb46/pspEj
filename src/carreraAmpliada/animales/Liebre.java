package carreraAmpliada.animales;

import carreraAmpliada.Animal;
import carreraAmpliada.Tunel;

import java.util.concurrent.Semaphore;

public class Liebre extends Animal {

    public int sleepTurn;

    public static final int DEFAULT_VELOCITY = 5;
    public Liebre(String name, Semaphore s) {
        super(name, s);
    }

    @Override
    public int getVelocity(boolean wind){
        if(sleepTurn > 0){
            sleepTurn--;
            return 0;
        }else{
            sleepTurn = 4;
            return DEFAULT_VELOCITY;
        }
    }

    @Override
    public void run(){

    }
}
