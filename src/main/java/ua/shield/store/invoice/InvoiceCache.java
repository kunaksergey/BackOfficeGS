package ua.shield.store.invoice;


import ua.shield.models.Invoice;
import ua.shield.store.Cache;

import java.util.List;

/**
 * Created by sa on 18.04.16.
 */
public class InvoiceCache extends Cache<Invoice> {
    private static final InvoiceCache INSTANCE = new InvoiceCache();

    {
        storage = new JdbcStorageInvoice();
    }

    public static InvoiceCache getInstance() {
        return INSTANCE;
    }

}
