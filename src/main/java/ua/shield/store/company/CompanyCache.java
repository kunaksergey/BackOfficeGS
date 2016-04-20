package ua.shield.store.company;

import ua.shield.models.Company;
import ua.shield.store.Cache;
import ua.shield.store.StorageBeen;

import java.util.List;

/**
 * Created by sa on 13.04.16.
 */
public class CompanyCache extends Cache<Company> {
    private static final CompanyCache INSTANCE = new CompanyCache();

    {
        storage = new JdbcStorageCompany();
    }

    private CompanyCache() {
    }

    public static CompanyCache getInstance() {
        return INSTANCE;
    }
}
