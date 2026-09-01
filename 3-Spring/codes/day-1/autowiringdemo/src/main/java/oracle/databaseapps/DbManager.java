package oracle.databaseapps;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class DbManager implements Manager<Object> {

    @Autowired
    private Reader<Object> reader;

//    private final Reader<Object> reader;
//    @Autowired
//    public DbManager(Reader<Object> reader) {
//        this.reader = reader;
//    }

    // @Autowired
//    public DbManager(@Qualifier("fileBean") Reader reader) {
//        this.reader = reader;
//    }


    @Override
    public Object fetchData() {
        return reader.getData();
    }
}
