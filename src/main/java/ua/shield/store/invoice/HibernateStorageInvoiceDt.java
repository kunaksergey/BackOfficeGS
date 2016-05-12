package ua.shield.store.invoice;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.shield.models.Invoice;
import ua.shield.models.InvoiceDt;
import ua.shield.store.HibernateStorageConnect;

import java.util.List;

/**
 * Created by sa on 11.04.16.
 */
public class HibernateStorageInvoiceDt {
    private final SessionFactory factory = HibernateStorageConnect.getINSTANCE().getFactory();


    public List<InvoiceDt> getInvoiceList() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from InvoiceDt").list();
        } finally {
            tx.commit();
            session.close();
        }
    }


    public InvoiceDt getInvoiceDtById(int uid) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            InvoiceDt i = (InvoiceDt) session.get(InvoiceDt.class, uid);
            return i;
        } finally {
            tx.commit();
            session.close();
        }
    }


    public void saveInvoiceById(Invoice invoice) {

    }


    public void addInvoice(Invoice invoice) {

    }


}
