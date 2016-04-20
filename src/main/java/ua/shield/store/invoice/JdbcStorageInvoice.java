package ua.shield.store.invoice;

import ua.shield.models.Company;
import ua.shield.models.Invoice;
import ua.shield.models.InvoiceDt;
import ua.shield.store.JdbcStorageBeen;
import ua.shield.store.StorageBeen;
import ua.shield.store.StorageBeenDt;
import ua.shield.store.company.JdbcStorageCompany;

import java.sql.*;


/**
 * Created by sa on 18.04.16.
 */
public class JdbcStorageInvoice extends JdbcStorageBeen<Invoice> {

    final StorageBeen<Company> storageCompany = new JdbcStorageCompany();
    final StorageBeenDt<InvoiceDt> storageInvoiceDt = new JdbcStorageInvoiceDt();

    @Override
    protected Invoice generateBeen(ResultSet rs) throws SQLException {
        Invoice invoice = new Invoice();
        ;
        invoice.setUid(rs.getInt("uid"));
        invoice.setNumber(rs.getString("number"));
        invoice.setDate(rs.getDate("datedoc"));
        invoice.setOurCompany(storageCompany.getBeenById(rs.getInt("our_id")));
        invoice.setClientCompany(storageCompany.getBeenById(rs.getInt("client_id")));
        invoice.setDescription(rs.getString("description"));
        invoice.setInvoiceDtList(storageInvoiceDt.getBeenListDt(rs.getInt("uid")));
        return invoice;
    }

    @Override
    public void updateBeen(Invoice been) {

    }

    @Override
    public void addBeen(Invoice been) {

    }
}


