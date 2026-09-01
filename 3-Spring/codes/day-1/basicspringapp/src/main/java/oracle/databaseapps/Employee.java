package oracle.databaseapps;

public class Employee {
    private int id;
    private String name;
    private Employee manager;

    public Employee() {
    }

    public Employee(int id, String name, Employee manager) {
        this.id = id;
        this.name = name;
        this.manager = manager;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
