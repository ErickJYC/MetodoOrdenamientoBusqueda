package app;

import controllers.*;
import views.View;

public class app {
    public static void main(String[] args) {
        View view = new View();
        SortingMethods sorter = new SortingMethods();
        SearchMethods searcher = new SearchMethods();
        Controller controller = new Controller(view, sorter, searcher);
        controller.start();
    }
}
