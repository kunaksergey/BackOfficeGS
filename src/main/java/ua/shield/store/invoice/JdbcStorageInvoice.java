package ua.shield.store.invoice;

import ua.shield.models.Company;
import ua.shield.models.Helper;
import ua.shield.models.Invoice;
import ua.shield.models.InvoiceDt;
import ua.shield.store.JdbcStorageBeen;
import ua.shield.store.StorageBeen;
import ua.shield.store.StorageBeenDt;
import ua.shield.store.company.JdbcStorageCompany;

import java.sql.*;
import java.util.Date;


/**
 * Created by sa on 18.04.16.
 */
public class JdbcStorageInvoice extends JdbcStorageBeen<Invoice> {

    final StorageBeen<Company> storageCompany = new JdbcStorageCompany();
    final StorageBeenDt<InvoiceDt> storageInvoiceDt = new JdbcStorageInvoiceDt();

    @Override
    protected Invoice generateBeen(ResultSet rs) throws SQLException {
        Invoice invoice = new Invoice();

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
    public Invoice createBeen() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Invoice invoice = new Invoice();
        invoice.setDate(new Date());
        invoice.setNumber(generateNumberInvoice());
        invoice.setOurCompany(storageCompany.createBeen());
        invoice.setClientCompany(storageCompany.createBeen());
        invoice.setInvoiceDtList(storageInvoiceDt.createBeen());
        return invoice;
    }

    @Override
    public void updateBeen(Invoice been) {

    }

    @Override
    public void addBeen(Invoice been) {

    }

    private String generateNumberInvoice() {
        Date date = new Date();
        return Helper.getNumberInvoice(date) + "/" + (getCountInvoicenByDate(date) + 1);
    }

    private int getCountInvoicenByDate(Date date) {
        try (
                PreparedStatement preparedStatement =
                        this.connection.prepareStatement("select count(uid) from invoice where datedoc=(?) group by uid  ")) {
            preparedStatement.setDate(1, new java.sql.Date(date.getTime()));
            try (final ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    return rs.getInt("count");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}


