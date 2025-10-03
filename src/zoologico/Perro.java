package zoologico;

public class Perro extends Animal{
    public String raza;

    public Perro(String name, int age, String raza){
        super(name,age);
        this.raza = raza;
    }

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println(" , raza: " + raza);
    }
}
