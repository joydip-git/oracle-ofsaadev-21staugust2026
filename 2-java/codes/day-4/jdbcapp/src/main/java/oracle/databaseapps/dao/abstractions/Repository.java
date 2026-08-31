package oracle.databaseapps.dao.abstractions;

import java.sql.SQLException;
import java.util.Collection;

public interface Repository<T, TKey> {
    T add(T data);

    T delete(TKey id);

    Collection<T> getAll() throws SQLException, ClassNotFoundException;

    T get(TKey id) throws SQLException, ClassNotFoundException;

    T update(TKey id, T data);
}
