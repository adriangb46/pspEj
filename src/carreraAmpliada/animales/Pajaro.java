package carreraAmpliada.animales;

import carreraAmpliada.Animal;
import carreraAmpliada.Logger;
import carreraAmpliada.Tunel;
import carreraAmpliada.Wind;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Pajaro extends Animal {

    public static final int DEFAULT_VELOCITY = 3;
    public static final int DEFAULT_FLIYING_VELOCITY = 10;

    public static final int WIND_SPEED = 5;

    private int fallingTurn;
    public Pajaro(String name, Semaphore s, Wind w, Logger out) {
        super(name, s, w, out);
        fallingTurn = 0;
    }

    @Override
    public int getVelocity(boolean wind,boolean tunel) {
        Random r = new Random();
        boolean flying = r.nextBoolean();
        boolean flyDirection = r.nextBoolean();
        boolean direction = r.nextBoolean();
        boolean fall = super.getDistance() % 10 == 0 && super.getDistance() > 0;

        if(flying){
            out.printEventln("El pajaro con nombre " + super.getNombre() + " esta volando en sentido " +
                    (direction?"positivo":"negativo"));

            int speed = (flyDirection?DEFAULT_FLIYING_VELOCITY:-DEFAULT_FLIYING_VELOCITY); // volando
            speed += (wind && !tunel?(direction?WIND_SPEED:-WIND_SPEED):0);//si es positivo y si hay viento y esta fuera del tunel
            return speed;
        }else{
            if(fall && fallingTurn <= 0){
                fallingTurn = 5;
            }
            if(fallingTurn > 0){
                fallingTurn--;
                return 0;
            }
            return DEFAULT_VELOCITY;
        }
    }
}
