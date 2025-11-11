package carreraAmpliada.animales;

import carreraAmpliada.Animal;
import carreraAmpliada.Tunel;

import java.util.concurrent.Semaphore;

public class Tortuga extends Animal {

    public static final int DEFAULT_VELOCITY = 2;


    public Tortuga(String name, Semaphore s) {
        super(name, s);
    }

    @Override
    public int getVelocity(boolean wind) {
        return DEFAULT_VELOCITY;
    }

    @Override
    public void run(){

    }

}
