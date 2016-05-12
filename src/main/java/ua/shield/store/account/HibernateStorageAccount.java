package ua.shield.store.account;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.shield.models.Account;

import java.util.List;

/**
 * Created by sa on 11.04.16.
 */
public class HibernateStorageAccount {
    private final SessionFactory factory;

    public HibernateStorageAccount() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.factory = new Configuration().configure().buildSessionFactory();
    }


    public List<Account> getAccountList() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from Account").list();
        } finally {
            tx.commit();
            session.close();
        }
    }


    public void close() {
        this.factory.close();
    }
}
