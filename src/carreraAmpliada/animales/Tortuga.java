package carreraAmpliada.animales;

import carreraAmpliada.*;

import java.io.PrintStream;
import java.util.concurrent.Semaphore;

public class Tortuga extends Animal {

    public static final int DEFAULT_VELOCITY = 2;
    public static final int BONUS = 3;


    public Tortuga(String name, Semaphore s, Wind w, Logger out) {
        super(name, s, w, out);
    }

    @Override
    public int getVelocity(boolean wind, boolean tunel) {
        if((super.getDistance() % 10) == 0 && super.getDistance() > 0 && !tunel){
            out.printEventln("La tortuga con nombre " + super.getNombre() + " ha conseguido bonus");
            return DEFAULT_VELOCITY + BONUS;
        }
        return DEFAULT_VELOCITY;
    }

}
