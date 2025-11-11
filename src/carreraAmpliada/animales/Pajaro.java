package carreraAmpliada.animales;

import carreraAmpliada.Animal;
import carreraAmpliada.Tunel;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Pajaro extends Animal {

    public static final int DEFAULT_VELOCITY = 3;
    public static final int DEFAULT_FLIYING_VELOCITY = 10;

    public static final int WIND_SPEED = 5;
    public Pajaro(String name, Semaphore s) {
        super(name, s);
    }

    @Override
    public int getVelocity(boolean wind) {
        if(new Random().nextBoolean()){
            int speed = (new Random().nextBoolean()?DEFAULT_FLIYING_VELOCITY:-DEFAULT_FLIYING_VELOCITY);
            speed += (wind?(new Random().nextBoolean()?WIND_SPEED:-WIND_SPEED):0);
            return speed;
        }else{
            return DEFAULT_VELOCITY;
        }
    }

    @Override
    public void run(){

    }

}
