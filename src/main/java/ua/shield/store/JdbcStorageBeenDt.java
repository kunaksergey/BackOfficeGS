package ua.shield.store;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sa on 19.04.16.
 * Абстрактный класс для классов имеющих родителя
 * расширяется интерфейсом implements StorageBeenDt<T> и методом getBeenListDt(int parentUid)
 * getBeenListDt(int parentUid) - возращает список классов по заданному родителю
 */
abstract public class JdbcStorageBeenDt<T> extends JdbcStorageBeen<T> implements StorageBeenDt<T> {

    /**
     * @param parentUid - Uid родителя
     * @return - Возвращает список детализаций для родителя
     */
    @Override
    public List<T> getBeenListDt(int parentUid) {
        List<T> listDt = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = this.connection.prepareStatement("select * from " + tableName + " where parentuid=(?)")) {
            preparedStatement.setInt(1, parentUid);
            try (final ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    listDt.add(generateBeen(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDt;
    }


}
