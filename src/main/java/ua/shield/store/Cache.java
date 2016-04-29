package ua.shield.store;

import java.util.List;

/**
 * Created by sa on 20.04.16.
 */
public class Cache<T> implements StorageBeen<T> {

    protected StorageBeen<T> storage;

    @Override
    public List<T> getBeenList() {
        return storage.getBeenList();
    }

    @Override
    public T getBeenById(int id) {
        return storage.getBeenById(id);
    }

    @Override
    public T createBeen() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return storage.createBeen();
    }


    @Override
    public void updateBeen(T been) {

    }

    @Override
    public void addBeen(T been) {

    }

    @Override
    public void close() {
        storage.close();
    }
}
