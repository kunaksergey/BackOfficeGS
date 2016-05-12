package ua.shield.store.person;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.shield.models.Company;
import ua.shield.models.Person;

import java.util.List;

/**
 * Created by sa on 11.04.16.
 */
public class HibernateStoragePerson {
    private final SessionFactory factory;

    public HibernateStoragePerson() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.factory = new Configuration().configure().buildSessionFactory();
    }


    public List<Person> getPersonList() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from Person").list();
        } finally {
            tx.commit();
            session.close();
        }
    }


    public Person getPersonById(int uid) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (Person) session.get(Person.class, uid);
        } finally {
            tx.commit();
            session.close();
        }
    }


    public void saveCompanyById(Company company) {

    }


    public void addCompany(Company company) {

    }


    public void close() {
        this.factory.close();
    }
}
