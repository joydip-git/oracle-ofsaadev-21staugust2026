package oracle.databaseapps.dao.abstractions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

public interface Repository<T, TKey> {
    T add(T data) throws Exception;

    T delete(TKey id) throws Exception;

    Collection<T> getAll() throws SQLException, ClassNotFoundException, IOException;

    T get(TKey id) throws SQLException, ClassNotFoundException, IOException;

    T update(TKey id, T data) throws Exception;
}
