package oracle.databaseapps;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class DbReader implements Reader<Object> {
    @Override
    public Object getData() {
        return "db data";
    }
}
