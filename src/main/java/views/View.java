package views;
import models.Person;
import java.util.Scanner;


public class View {
    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("1. Ingresar personas");
        System.out.println("2. Ordenar personas");
        System.out.println("3. Buscar persona");
        System.out.println("4. Salir");
        return scanner.nextInt();
    }

    public Person inputPerson() {
        System.out.print("Nombre: ");
        String name = scanner.next();
        System.out.print("Edad: ");
        int age = scanner.nextInt();
        return new Person(name, age);
    }

    public int selectSortingMethod() {
        System.out.println("1. Burbuja por nombre");
        System.out.println("2. Inserción por edad");
        return scanner.nextInt();
    }

    public int selectSearchCriterion() {
        System.out.println("1. Buscar por nombre");
        System.out.println("2. Buscar por edad");
        return scanner.nextInt();
    }

    public void displayPersons(Person[] persons) {
        for (Person p : persons) {
            System.out.println(p);
        }
    }

    public void displaySearchResult(Person person) {
        if (person != null) {
            System.out.println("Person encontrada: " + person);
        } else {
            System.out.println("Person no encontrada.");
        }
    }

    public String inputName() {
        System.out.print("Nombre a buscar: ");
        return scanner.next();
    }

    public int inputAge() {
        System.out.print("Edad a buscar: ");
        return scanner.nextInt();
    }
}
