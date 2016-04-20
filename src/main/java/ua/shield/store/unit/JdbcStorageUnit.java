package ua.shield.store.unit;

import ua.shield.models.Unit;
import ua.shield.store.JdbcStorageBeen;

import java.sql.*;


/**
 * Created by sa on 19.04.16.
 */
public class JdbcStorageUnit extends JdbcStorageBeen<Unit> {

    @Override
    public void updateBeen(Unit been) {

    }

    @Override
    public void addBeen(Unit been) {

    }


    @Override
    public void close() {

    }

    protected Unit generateBeen(ResultSet rs) throws SQLException {
        Unit unit = new Unit();
        unit.setUid(rs.getInt("uid"));
        unit.setName(rs.getString("name"));
        unit.setFullName(rs.getString("fullname"));
        return unit;
    }


}
