package ua.shield.store;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.shield.models.Company;
import ua.shield.models.Helper;

import java.util.List;

/**
 * Created by sa on 11.05.16.
 */
public class HibernateStorageBeen<T> implements StorageBeen<T> {
    protected final SessionFactory factory = new Configuration().configure().buildSessionFactory();
    protected final Class<T> currentClass = Helper.getClassFromGeneric(this.getClass());

    public HibernateStorageBeen() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<T> getBeenList() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from " + Helper.getSimpleClassNameFromGeneric(this.getClass())).list();
        } finally {
            tx.commit();
            session.close();
        }
    }


    public T getBeenById(int uid) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (T) session.get(currentClass, uid);
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public T createBeen() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return null;
    }


    @Override
    public void updateBeen(T been) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(been);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public void saveCompanyById(Company company) {

    }


    public void addBeen(T been) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(been);
        } finally {
            tx.commit();
            session.close();
        }
    }

    public void deleteBeen(T been) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(been);
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void close() {

    }
}
