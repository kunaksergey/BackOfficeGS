package ua.shield.store.company;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import ua.shield.models.Company;

import java.util.List;

/**
 * Created by sa on 11.04.16.
 */
public class HibernateStorage {
   /*private final SessionFactory factory;

    public HibernateStorage()  {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.factory = new Configuration().configure().buildSessionFactory();
    }



    @Override
    public List<Company> getCompanyList() {
        final Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        try{
            return session.createQuery("from Company").list();
        }finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public Company getCompanyById(int id) {
        return null;
    }

    @Override
    public void saveCompanyById(Company company) {

    }

    @Override
    public void addCompany(Company company) {

    }

    @Override
    public void close() {
        this.factory.close();
    }*/
}
