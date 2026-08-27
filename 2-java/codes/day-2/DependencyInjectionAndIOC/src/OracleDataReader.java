public class OracleDataReader implements Reader {
    @Override
    public String getData(String path) {
        return "data from oracle db " + path;
    }
}
