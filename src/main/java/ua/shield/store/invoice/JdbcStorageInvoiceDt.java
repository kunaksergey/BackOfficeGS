package ua.shield.store.invoice;

import ua.shield.models.InvoiceDt;
import ua.shield.models.Unit;
import ua.shield.store.JdbcStorageBeenDt;
import ua.shield.store.StorageBeen;
import ua.shield.store.unit.JdbcStorageUnit;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sa on 18.04.16.
 */
public class JdbcStorageInvoiceDt extends JdbcStorageBeenDt<InvoiceDt> {

    private final StorageBeen<Unit> storageUnit = new JdbcStorageUnit();

    @Override
    protected InvoiceDt generateBeen(ResultSet rs) throws SQLException {
        InvoiceDt invoiceDt = new InvoiceDt();
        invoiceDt.setUid(rs.getInt("uid"));
        invoiceDt.setParentUid(rs.getInt("parentUid"));
        invoiceDt.setDecription(rs.getString("description"));
        invoiceDt.setUnit(storageUnit.getBeenById(rs.getInt("unit_id")));
        invoiceDt.setAmount(rs.getDouble("amount"));
        invoiceDt.setPrice(rs.getDouble("price"));
        invoiceDt.setSum(rs.getDouble("sum"));
        return invoiceDt;
    }

    @Override
    public void updateBeen(InvoiceDt been) {

    }

    @Override
    public void addBeen(InvoiceDt been) {

    }
}


