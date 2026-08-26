public class Person {
    private String name;
    private static String location;

    static {
        location = "NA";
        System.out.println("static initializer...");
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
        //System.out.println("parameterized");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getLocation() {
        return location;
    }

    public static void setLocation(String location) {
        location = location;
    }

    public String getInfo() {
        return "Name=" + name + ", Location=" + location;
    }
}
