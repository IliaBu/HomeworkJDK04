import java.util.HashMap;
import java.util.List;

public class EmployeeHandbook {

    private final HashMap<Integer, Employee> employeeHandbook = new HashMap<>();

    public EmployeeHandbook() {
        Employee employee = new Employee("89245852356", "Сергей", 10);
        Employee employee1 = new Employee("89222214585", "Игорь", 5);
        Employee employee2 = new Employee("89222222458", "Денис", 6);
        Employee employee3 = new Employee("89245856955", "Юлия", 7);
        Employee employee4 = new Employee("89365258965", "Илья", 11);
        Employee employee5 = new Employee("89214112222", "Виктория", 5);
        employeeHandbook.put(employee.getId(), employee);
        employeeHandbook.put(employee1.getId(), employee1);
        employeeHandbook.put(employee2.getId(), employee2);
        employeeHandbook.put(employee3.getId(), employee3);
        employeeHandbook.put(employee4.getId(), employee4);
        employeeHandbook.put(employee5.getId(), employee5);
    }

    public void addNewEmployee(Employee employee){
        if (employee == null)
            throw new RuntimeException("Попытка добавить Null вместо сотрудника");
        employeeHandbook.put(employee.getId(), employee);
    }

    public List<Employee> findEmployeeByExp(int exp){
        List<Employee> employees = employeeHandbook.values().stream().filter(employee -> employee.getExperience() >= exp).toList();
        if(employees.isEmpty())
            throw new RuntimeException("Сотрудников с таким стажем нет");
        return employees;
    }

    public List<Employee> findEmployeePhoneNumberByName(String name){
        List<Employee> employees = employeeHandbook.values().stream().filter(employee -> employee.getName().equals(name)).toList();
        if(employees.isEmpty())
            throw new RuntimeException("Сотрудников с таким номером телефона нет");
        return employees;
    }

    public Employee findEmployeeByPersonnelNumber(int id){
        return employeeHandbook.values().stream().filter(employee -> employee.getId() == id).findAny().orElseThrow(() -> new RuntimeException("Cотрудника с таким номером нет"));
    }

    public void printEmployees(){
        employeeHandbook.values().forEach(System.out::println);
        System.out.println();
    }

    public HashMap<Integer, Employee> getEmployeeHandbook() {
        return employeeHandbook;
    }

}
