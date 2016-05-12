package ua.shield.store.person;

import ua.shield.models.Account;
import ua.shield.models.Person;
import ua.shield.store.Cache;
import ua.shield.store.JdbcStorageBeen;
import ua.shield.store.StorageBeen;
import ua.shield.store.StorageBeenDt;
import ua.shield.store.account.JdbcStorageAccount;

/**
 * Created by sa on 20.04.16.
 */
public class PersonCache extends Cache<Person> {
    private static final PersonCache INSTANCE = new PersonCache();

    {
        storage = new JdbcStoragePerson();
    }

    private PersonCache() {
    }

    public static PersonCache getInstance() {
        return INSTANCE;
    }
}
