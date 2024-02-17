public class Main {
   /* Создать справочник сотрудников
    Необходимо:
    Создать класс справочник сотрудников, который содержит внутри
    коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
    Табельный номер
    Номер телефона
    Имя
    Стаж
    Добавить метод, который ищет сотрудника по стажу (может быть список)
    Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
    Добавить метод, который ищет сотрудника по табельному номеру
    Добавить метод добавление нового сотрудника в справочник
    */

    public static void main(String[] args) {
        System.out.println("\nСписок сотрудников:");
        EmployeeHandbook handbook= new EmployeeHandbook();
        handbook.printEmployees();

        System.out.println("\nСотрудники, чей стаж не менее 10 лет:");
        handbook.findEmployeeByExp(10).forEach(System.out::println);

        System.out.println("\nСписок телефонов сотрудников, с именем Илья:");
        handbook.findEmployeePhoneNumberByName("Илья").forEach(System.out::println);

        System.out.println("\nСотрудник с табельным номером 4:");
        System.out.println(handbook.findEmployeeByPersonnelNumber(4));

        System.out.println("\nСписок добавленных сотрудников:");
        handbook.addNewEmployee(new Employee("89444444444", "Илья", 4));
        handbook.addNewEmployee(new Employee("89241547859", "Валерия", 5));
        handbook.printEmployees();
    }
}
