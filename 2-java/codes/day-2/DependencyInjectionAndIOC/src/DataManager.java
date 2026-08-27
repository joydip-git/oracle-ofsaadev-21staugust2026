public class DataManager {

    private final Reader reader;

    public DataManager(Reader reader) {
        this.reader = reader;
    }

    public String fetchData(String path) {
        return reader.getData(path);
    }
}
