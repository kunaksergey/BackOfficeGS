package ua.shield.store;

import java.util.List;

/**
 * Created by sa on 19.04.16.
 * Интерфейс детализаций родителя
 */
public interface StorageBeenDt<T> extends StorageBeen<T> {
    /**
     * @param parentUid - Uid родителя
     * @return - Возвращает список детализаций для родителя
     */
    List<T> getBeenListDt(int parentUid);
}