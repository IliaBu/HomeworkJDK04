public class Employee {

    private static int counter = 00;
    private final int id = ++counter;
    private final String phoneNumber;
    private final String name;
    private final int experience;


    public Employee(String phoneNumber, String name, int experience) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return String.format("Табельный номер: %d Имя: %-10s  Номер телефона: %-10s стаж: %d",
                id, name, phoneNumber,experience);
    }

}
