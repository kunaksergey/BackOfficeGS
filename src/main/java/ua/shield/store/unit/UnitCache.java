package ua.shield.store.unit;

import ua.shield.models.Unit;
import ua.shield.store.Cache;
import ua.shield.store.StorageBeen;

import java.util.List;

/**
 * Created by sa on 19.04.16.
 */
public class UnitCache extends Cache<Unit> {
    private static final UnitCache INCTANCE = new UnitCache();

    {
        // storage = new JdbcStorageUnit();
        storage = new HibernateStorageUnit();
    }

    private UnitCache() {

    }

    static public UnitCache getInstance() {
        return INCTANCE;
    }

}
