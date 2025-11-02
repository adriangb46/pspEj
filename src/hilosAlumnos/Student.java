package hilosAlumnos;

public class Student implements Runnable{
    private String name;

    public Student(String name){
        this.name = name;
    }

    @Override
    public void run() {
        if(name.toUpperCase().charAt(0) != 'A') {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hola, soy " + name + " y este es mi mensaje numero " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }else{
            System.out.println("Mira que llamarme " + name + " ... pues me cierro");
        }
    }
}
