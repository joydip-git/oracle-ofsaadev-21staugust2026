public class DataManager implements Manager {
    private final Reader reader;

    public DataManager(Reader reader) {
        this.reader = reader;
    }

    public String fetchData() {
        return reader.getData();
    }
}
