package oracle.sprinbootapps;

import java.util.Collection;

public interface CoreRepository<T> extends AutoCloseable{
    Collection<Category> getAll();
    T get(int id);
    T add(T data);
    T update(int id, T data);
    T delete(int id);
}
