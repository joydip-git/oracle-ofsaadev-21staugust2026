package oracle.databaseapps;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FileManager implements Manager<String> {
    //@Autowired
    private final Reader<String> reader;

    @Autowired
    public FileManager(Reader<String> reader) {
        this.reader = reader;
    }

    // @Autowired
//    public DataManager(@Qualifier("fileBean") Reader reader) {
//        this.reader = reader;
//    }


    @Override
    public String fetchData() {
        return reader.getData();
    }
}
