package ua.shield.store.invoice;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.shield.models.Company;
import ua.shield.models.Invoice;
import ua.shield.store.HibernateStorageConnect;

import java.util.List;

/**
 * Created by sa on 11.04.16.
 */
public class HibernateStorageInvoice {
    private final SessionFactory factory = HibernateStorageConnect.getINSTANCE().getFactory();


    public List<Invoice> getInvoiceList() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from Invoice").list();
        } finally {
            tx.commit();
            session.close();
        }
    }


    public Invoice getInvoiceById(int uid) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Invoice i = (Invoice) session.get(Invoice.class, uid);
            return i;
        } finally {
            tx.commit();
            session.close();
        }
    }


    public void saveInvoiceById(Invoice invoice) {

    }


    public void addInvoice(Invoice invoice) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(invoice);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to UPDATE for an invoice*/
    public void updateInvoice(Invoice invoice) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(invoice);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an invoice from the records */
    public void deleteInvoice(Invoice invoice) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(invoice);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
