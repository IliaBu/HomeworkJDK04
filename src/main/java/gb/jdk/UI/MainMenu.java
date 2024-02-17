package gb.jdk.UI;
import java.io.IOException;
import java.util.ArrayList;

import static gb.jdk.EmployeeHandbook.*;

public class MainMenu extends Menu {

    public MainMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::showTask1, "Задача 1"));
        menuItems.add(new MenuItem(this::showTask2, "Задача 2"));
        menuItems.add(new MenuItem(this::showTask3, "Задача 3"));
        menuItems.add(new MenuItem(this::showTask4, "Задача 4"));
        menuItems.add(new MenuItem(this::quit, "Выйти"));
    }

    public void quit() {
        ConsoleUi.close();
    }

    public void showTask1() throws IOException {
        ConsoleUi.println("Добавить метод, который ищет сотрудника по стажу (может быть список) \n", Colors.MAGENTA);

    }

    public void showTask2() {
        ConsoleUi.println("Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список) \n", Colors.MAGENTA);

    }

    public void showTask3() {
        ConsoleUi.println("Добавить метод, который ищет сотрудника по табельному номеру \n", Colors.MAGENTA);

    }

    public void showTask4() {
        ConsoleUi.println("Добавить метод добавление нового сотрудника в справочник \n", Colors.MAGENTA);

    }

}
