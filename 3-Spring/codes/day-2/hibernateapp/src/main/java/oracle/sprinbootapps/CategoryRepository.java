package oracle.sprinbootapps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collection;

public class CategoryRepository implements CoreRepository<Category> {
    private final SessionFactory sessionFactory;

    public CategoryRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
//    public CategoryRepository() {
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        sessionFactory = configuration.buildSessionFactory();
//    }

    @Override
    public Collection<Category> getAll() {
        return null;
    }

    @Override
    public Category get(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Category.class, id);
        }
    }

    @Override
    public Category add(Category data) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.persist(data);
                transaction.commit();
                return data;
            } catch (Exception e) {
                if (transaction != null)
                    transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public Category update(int id, Category data) {
        return null;
    }

    @Override
    public Category delete(int id) {
        return null;
    }

    @Override
    public void close() throws Exception {
        if (sessionFactory != null)
            sessionFactory.close();
    }
}
