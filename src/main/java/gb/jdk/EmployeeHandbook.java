package gb.jdk;

import gb.jdk.UI.Colors;
import gb.jdk.UI.ConsoleUi;

import java.util.HashMap;
import java.util.List;

public class EmployeeHandbook {

    private final HashMap<Integer, Employee> employeeHandbook = new HashMap<>();

    public EmployeeHandbook() {
        Employee employee = new Employee("89245852356", "Sergey", 10);
        Employee employee1 = new Employee("89222214585", "Igor", 5);
        Employee employee2 = new Employee("89222222458", "Denis", 6);
        Employee employee3 = new Employee("89245856955", "Julia", 7);
        Employee employee4 = new Employee("89365258965", "Ilya", 11);
        Employee employee5 = new Employee("89214112222", "Victoria", 5);
        employeeHandbook.put(employee.getId(), employee);
        employeeHandbook.put(employee1.getId(), employee1);
        employeeHandbook.put(employee2.getId(), employee2);
        employeeHandbook.put(employee3.getId(), employee3);
        employeeHandbook.put(employee4.getId(), employee4);
        employeeHandbook.put(employee5.getId(), employee5);
    }

    public void addNewEmployee(Employee employee){
        if (employee == null)
            ConsoleUi.println("Попытка добавить Null вместо сотрудника", Colors.RED);
        employeeHandbook.put(employee.getId(), employee);
    }

    public List<Employee> findEmployeeByExp(int exp){
        List<Employee> employees = employeeHandbook.values().stream().filter(employee -> employee.getExperience() >= exp).toList();
        if(employees.isEmpty())
            ConsoleUi.println("Сотрудников с таким стажем нет!", Colors.RED);
        return employees;
    }

    public List<Employee> findEmployeePhoneNumberByName(String name){
        List<Employee> employees = employeeHandbook.values().stream().filter(employee -> employee.getName().equals(name)).toList();
        if(employees.isEmpty())
            ConsoleUi.println("Сотрудников с таким номером телефона нет!", Colors.RED);
        return employees;
    }

    public Employee findEmployeeByPersonnelNumber(int id){
        return employeeHandbook.values().stream().filter(employee -> employee.getId() == id).findAny().orElseThrow(() -> new RuntimeException("Cотрудника с таким номером нет!"));
    }

    public void printEmployees(){
        employeeHandbook.values().forEach(System.out::println);
        System.out.println();
    }

    public HashMap<Integer, Employee> getEmployeeHandbook() {
        return employeeHandbook;
    }

}
