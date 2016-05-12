package ua.shield.store.company;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.shield.models.Company;
import ua.shield.store.HibernateStorageConnect;

import java.util.List;

/**
 * Created by sa on 11.04.16.
 */
public class HibernateStorageCompany {
    public HibernateStorageCompany() {

    }




    public List<Company> getCompanyList() {
        final Session session = HibernateStorageConnect.getINSTANCE().getFactory().openSession();
        Transaction tx=session.beginTransaction();
        try{
            return session.createQuery("from Company").list();
        }finally {
            tx.commit();
            session.close();
        }
    }


    public Company getCompanyById(int uid) {
        final Session session = HibernateStorageConnect.getINSTANCE().getFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Company c = (Company) session.get(Company.class, uid);
            return c;
        } finally {
            tx.commit();
            session.close();
        }
    }


    public void saveCompanyById(Company company) {

    }


    public void addCompany(Company company) {

    }


 /*   public void close() {
        this.factory.close();
    }*/
}
