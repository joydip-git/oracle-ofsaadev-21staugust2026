public abstract class DataReader implements Reader {
    private String sourcePath;

    public DataReader() {
    }

    public DataReader(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    //public abstract String getData();
}
