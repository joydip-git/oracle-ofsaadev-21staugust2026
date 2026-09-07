package com.oracle.helidonapps.productservice.repository;

import java.util.Collection;

public interface RepositoryContract<T,Id> {
    Collection<T> getAll();
    T get(Id id);
    T add(T data);
    T update(Id id, T data);
    T delete(Id id);
}
