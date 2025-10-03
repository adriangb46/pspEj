package zoologico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public  final static String MENU = "" +
            "1) Añadir animal\n" +
            "2) Mostrar todos los animales del refugio\n\n" +
            "0) Salir\n> ";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        List<Animal> animales = new ArrayList<>();

        int op;
        do{
            System.out.print(MENU);
            op = sc.nextInt();
            sc.nextLine();
            switch (op){
                case 1:
                    System.out.print("Dime el nombre del animal\n>");
                    String name = sc.nextLine();
                    System.out.print("Dime la edad del animal\n>");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Es perro(p) o gato(g)?");
                    String tipo = sc.nextLine();
                    switch (tipo.toLowerCase()){
                        case "p":
                            System.out.println("Dime la raza");
                            String raza = sc.nextLine();
                            animales.add(new Perro(name,age,raza));
                            break;

                        case "g":
                            System.out.println("Dime la longuitud de los bigotes");
                            int bigotes = sc.nextInt();
                            sc.nextLine();
                            animales.add(new Gato(name,age,bigotes));
                            break;
                    }
                    break;
                case 2:
                   for(Animal a : animales){
                       a.mostrarDatos();
                   }
                    break;
                default:
            }
        }while (op != 0);
    }


}
