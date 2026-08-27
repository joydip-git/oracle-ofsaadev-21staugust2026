//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Factory factory = Factory.instantiate();
        Reader reader = factory.createReader(ReaderType.File);
        DataManager manager = new DataManager(reader);
        String data = manager.fetchData("C:\\data.txt");
        System.out.println(data);
    }
}