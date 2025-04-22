package controllers;
import models.Person;
import views.View;

import java.util.ArrayList;

public class Controller {
    private View view;
    private SortingMethods sorter;
    private SearchMethods searcher;
    private ArrayList<Person> personList = new ArrayList<>();

    public Controller(View view, SortingMethods sorter, SearchMethods searcher) {
        this.view = view;
        this.sorter = sorter;
        this.searcher = searcher;
    }

    public void start() {
        while (true) {
            int option = view.showMenu();
            switch (option) {
                case 1 -> inputPersons();
                case 2 -> sortPersons();
                case 3 -> searchPerson();
                case 4 -> System.exit(0);
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    public void inputPersons() {
        personList.add(view.inputPerson());
    }

    public void sortPersons() {
        Person[] array = personList.toArray(new Person[0]);
        int opt = view.selectSortingMethod();
        switch (opt) {
            case 1 -> sorter.sortByNameWithBubble(array);
            case 2 -> sorter.sortByAgeWithInsertion(array);
        }
        personList.clear();
        for (Person p : array) personList.add(p);
        view.displayPersons(array);
    }

    public void searchPerson() {
        Person[] array = personList.toArray(new Person[0]);
        int opt = view.selectSearchCriterion();
        Person result = null;

        if (opt == 1) {
            if (!searcher.isSortedByName(array)) {
                sorter.sortByNameWithBubble(array);
            }
            String name = view.inputName();
            result = searcher.binarySearchByName(array, name);
        } else if (opt == 2) {
            if (!searcher.isSortedByAge(array)) {
                sorter.sortByAgeWithInsertion(array);
            }
            int age = view.inputAge();
            result = searcher.binarySearchByAge(array, age);
        }

        view.displaySearchResult(result);
    }
}
