package ua.shield.store;

import ua.shield.models.Helper;
import ua.shield.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sa on 19.04.16.
 * Абстрактный класс родитель для классов верхнего уровня
 */
abstract public class JdbcStorageBeen<T> implements StorageBeen<T> {
    protected final Connection connection;
    protected final String tableName = Helper.getTableNameFromGeneric(this.getClass(), 0);

    /**
     * конструктор создающий соеденение
     */
    public JdbcStorageBeen() {
        final Settings settings = Settings.getInstance();
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * @return возвращает список классов верхнего уровня типа T
     */
    @Override
    public List<T> getBeenList() {
        final List<T> beenList = new ArrayList<>();
        try (final Statement statement = this.connection.createStatement();
             final ResultSet rs = statement.executeQuery("select * from " + tableName)) {
            while (rs.next()) {
                beenList.add(generateBeen(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beenList;
    }

    /**
     * @param uid - Uid класса
     * @return возвращает класс по Uid
     */
    @Override
    public T getBeenById(int uid) {
        try (
                PreparedStatement preparedStatement = this.connection.prepareStatement("select * from " + tableName + " where uid=(?)")) {
            preparedStatement.setInt(1, uid);
            try (final ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    return generateBeen(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Закрывает соеденение
     */
    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBeen(T been) {

    }

    /**
     * @return возвращает пустой объект класса
     */
    public abstract T createBeen() throws IllegalAccessException, ClassNotFoundException, InstantiationException;

    abstract protected T generateBeen(ResultSet rs) throws SQLException;


}
