package ua.shield.store;

import java.util.List;

/**
 * Created by sa on 20.04.16.
 */
public class CacheDt<T> extends Cache<T> implements StorageBeenDt<T> {
    protected StorageBeenDt<T> storage;

    @Override
    public List<T> getBeenListDt(int parentUid) {
        return storage.getBeenListDt(parentUid);
    }
}
