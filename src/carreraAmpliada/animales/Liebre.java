package carreraAmpliada.animales;

import carreraAmpliada.Animal;
import carreraAmpliada.Logger;
import carreraAmpliada.Tunel;
import carreraAmpliada.Wind;

import java.io.PrintStream;
import java.util.concurrent.Semaphore;

public class Liebre extends Animal {

    public int sleepTurn;
    public int fallTrun;
    private int avenceTurn;
    private boolean lastFall;

    public static final int DEFAULT_VELOCITY = 5;
    public Liebre(String name, Semaphore s, Wind w, Logger out) {
        super(name, s, w, out);
        fallTrun = 0;
        sleepTurn = 0;
        avenceTurn = 4;
        lastFall = false;
    }

    @Override
    public int getVelocity(boolean wind,boolean tunel) {
        if (wind) {
            sleepTurn = 0;
        }

        if (sleepTurn > 0) {
            sleepTurn--;
            return 0;
        }

        if (fallTrun > 0) {
            fallTrun--;
            return 0;
        }

        if (!tunel && super.getDistance() > 0 && super.getDistance() % 10 == 0 && !lastFall) {
            fallTrun = 5;
            lastFall = true;
            out.printEventln("La liebre con nombre " + super.getNombre() + " se ha resbalado en un charco");
            return 0;
        }

        if (super.getDistance() % 10 != 0) {
            lastFall = false;
        }

        if (avenceTurn > 0) {
            avenceTurn--;
            return DEFAULT_VELOCITY;
        } else {
            // Se duerme 10s después de 4s de avanzar
            sleepTurn = 10;
            avenceTurn = 4;
            out.printEventln("La liebre con nombre " + super.getNombre() + " se ha dormido");
            return 0;
        }

        /*
        if (super.getDistance() % 10 == 0 && super.getDistance() > 0 && !lastFall && !tunel) {
            fallTrun = 5;
            out.printEventln("La libre con nombre " + super.getNombre() + " se ha caido");
            lastFall = true;
        }

        if (super.getDistance() % 10 != 0) {
            lastFall = false;
        }

        if (wind) {
            sleepTurn = 0;
        }

        if (sleepTurn > 0) {
            sleepTurn--;
            return 0;
        }

        if(fallTrun > 0){
            fallTrun--;
            return 0;
        }

        if(avenceTurn <=1){
            sleepTurn = 10;
            avenceTurn = 5;
            out.printEventln("La libre con nombre " + super.getNombre() + " se ha dormido");
        }

        lastFall = !lastFall;
        avenceTurn--;
        return DEFAULT_VELOCITY;
    */
    }
}
