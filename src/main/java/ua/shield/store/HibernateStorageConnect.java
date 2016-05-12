package ua.shield.store;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by sa on 11.05.16.
 */
public class HibernateStorageConnect {
    private static HibernateStorageConnect INSTANCE = new HibernateStorageConnect();

    private HibernateStorageConnect() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static HibernateStorageConnect getINSTANCE() {
        return INSTANCE;
    }

    public SessionFactory getFactory() {
        return new Configuration().configure().buildSessionFactory();
    }


}
