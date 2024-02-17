package gb.jdk.UI;

import gb.jdk.Employee;
import gb.jdk.EmployeeHandbook;
import java.util.ArrayList;

public class MainMenu extends Menu {

    private final EmployeeHandbook handbook = new EmployeeHandbook();

    public MainMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::showTask0, "Вывести список сотрудников"));
        menuItems.add(new MenuItem(this::showTask1, "Поиск сотрудника по стажу"));
        menuItems.add(new MenuItem(this::showTask2, "Показать список телефонов указанного сотрудника"));
        menuItems.add(new MenuItem(this::showTask3, "Поиск сотрудника по табельному номеру"));
        menuItems.add(new MenuItem(this::showTask4, "Добавить нового сторудника"));
        menuItems.add(new MenuItem(this::quit, "Выйти"));
    }

    public void showTask0() {
        ConsoleUi.println("\nСписок сотрудников:", Colors.MAGENTA);
        handbook.printEmployees();
    }

    public void showTask1() {
        ConsoleUi.println("Добавить метод, который ищет сотрудника по стажу (может быть список) \n", Colors.MAGENTA);
        int exp;
        boolean flag = true;
        while (flag) {
            ConsoleUi.print("Введите стаж сотрудника: ", Colors.BLUE);
            if (ConsoleUi.scanner.hasNextInt()) {
                exp = ConsoleUi.scanner.nextInt();
                ConsoleUi.println("\nСотрудники, чей стаж не менее " + exp + " лет:", Colors.BLUE);
                handbook.findEmployeeByExp(exp).forEach(System.out::println);
                flag = false;
            } else {
                ConsoleUi.println("Допускается ввод только цифр! ", Colors.RED);
                ConsoleUi.scanner.nextLine();
            }
        }
    }

    public void showTask2() {
        ConsoleUi.println("Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список) \n", Colors.MAGENTA);
        String name;
        ConsoleUi.print("Введите имя сотрудника: ", Colors.BLUE);
        name = ConsoleUi.scanner.next();
        ConsoleUi.println("\nСписок телефонов сотрудников, с именем " + name + " :", Colors.BLUE);
        handbook.findEmployeePhoneNumberByName(name).forEach(System.out::println);
    }

    public void showTask3() {
        ConsoleUi.println("Добавить метод, который ищет сотрудника по табельному номеру \n", Colors.MAGENTA);
        int id;
        boolean flag = true;
        while (flag) {
            ConsoleUi.print("Введите стаж сотрудника: ", Colors.BLUE);
            if (ConsoleUi.scanner.hasNextInt()) {
                id = ConsoleUi.scanner.nextInt();
                ConsoleUi.println("\nСотрудник с табельным номером " + id + " :", Colors.BLUE);
                ConsoleUi.println(handbook.findEmployeeByPersonnelNumber(id).toString(), Colors.RESET);
                flag = false;
            } else {
                ConsoleUi.println("Допускается ввод только цифр! ", Colors.RED);
                ConsoleUi.scanner.nextLine();
            }
        }
    }

    public void showTask4() {
        ConsoleUi.println("Добавить метод добавление нового сотрудника в справочник \n", Colors.MAGENTA);

        String name = "";
        String phone = "";
        int exp = 0;

        ConsoleUi.print("Введите имя сотрудника: ", Colors.BLUE);
        name = ConsoleUi.scanner.next();

        ConsoleUi.print("Введите номер телефона сотрудника: ", Colors.BLUE);
        phone = ConsoleUi.scanner.next();

        boolean flag = true;
        while (flag) {
            ConsoleUi.print("Введите стаж сотрудника: ", Colors.BLUE);
            if (ConsoleUi.scanner.hasNextInt()) {
                exp = ConsoleUi.scanner.nextInt();
                flag = false;
            } else {
                ConsoleUi.println("Допускается ввод только цифр! ", Colors.RED);
                ConsoleUi.scanner.nextLine();
            }
        }

        System.out.println("\nСписок добавленных сотрудников:");
        handbook.addNewEmployee(new Employee(phone, name, exp));
        handbook.printEmployees();
    }

    public void quit() {
        ConsoleUi.close();
    }
}
