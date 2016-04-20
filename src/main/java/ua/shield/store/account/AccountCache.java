package ua.shield.store.account;

import ua.shield.models.Account;
import ua.shield.store.Cache;
import ua.shield.store.StorageBeen;
import ua.shield.store.StorageBeenDt;

import java.util.List;

/**
 * Created by sa on 18.04.16.
 */
public class AccountCache extends Cache<Account> {
    private static final AccountCache INSTANCE = new AccountCache();

    {
        storage = new JdbcStorageAccount();
    }

    private AccountCache() {
    }

    public static AccountCache getInstance() {
        return INSTANCE;
    }
}


