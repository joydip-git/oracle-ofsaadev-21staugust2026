package oracle.databaseapps;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component
@Repository
public class FileReader implements Reader<String> {
    @Override
    public String getData() {
        return "file data";
    }
}
