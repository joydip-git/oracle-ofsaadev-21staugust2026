package oracle.sprinbootapps.pmsapp.services.abstractions;

import java.util.Collection;

public interface ServiceManager<TCommand, TQuery, Id> {
    TQuery add(TCommand data);

    TQuery delete(Id id);

    Collection<TQuery> getAll();

    TQuery get(Id id);

    TQuery update(Id id, TCommand data);
}
