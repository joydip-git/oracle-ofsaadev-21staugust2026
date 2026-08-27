public class TextFileReader implements Reader {
    @Override
    public String getData(String path) {
        return "data from text file " + path;
    }
}
