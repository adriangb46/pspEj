package zoologico;

public class Animal {
    public String name;
    public int age;

    public Animal(String name, int age){
        this.age = age;
        this.name = name;
    }

    public void mostrarDatos(){
        System.out.print(name + " , " + age);
    }
}
