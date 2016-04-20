package ua.shield.store;

import java.util.List;

/**
 * Created by sa on 19.04.16.
 * Интерфейс для класса родителя
 */
public interface StorageBeen<T> {

    /**
     * @return список классов данного типа
     */
    List<T> getBeenList();

    /**
     * @param id - id класса
     * @return класс по задонному id
     */
    T getBeenById(int id);


    /**
     * @param been обновляет класс в базе
     */
    void updateBeen(T been);

    /**
     * @param been добавляет класс в базу
     */
    void addBeen(T been);

    /**
     * закрывает соеденение
     */
    void close();
}
