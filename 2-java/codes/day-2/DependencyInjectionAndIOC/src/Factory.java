public class Factory {

    private static Factory instance;

    private Factory() {
        System.out.println("created..");
    }

    public static Factory instantiate() {
        if (instance == null)
            instance = new Factory();

        return instance;
    }

    public Reader createReader(ReaderType readerType) {
        return switch (readerType) {
            case ReaderType.Database -> new OracleDataReader();
            case ReaderType.File -> new TextFileReader();
            default -> null;
        };
    }
}
