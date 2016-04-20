package ua.shield.store.account;

import ua.shield.models.Account;
import ua.shield.store.JdbcStorageBeenDt;


import java.sql.*;

/**
 * Created by sa on 18.04.16.
 */
public class JdbcStorageAccount extends JdbcStorageBeenDt<Account> {

    @Override
    public void updateBeen(Account been) {

    }

    @Override
    public void addBeen(Account been) {

    }

    @Override
    protected Account generateBeen(ResultSet rs) throws SQLException {
        Account account = new Account();
        account.setUid(rs.getInt("uid"));
        account.setParentUid(rs.getInt("parentUid"));
        account.setNumber(rs.getString("number"));
        account.setNameBank(rs.getString("namebank"));
        account.setAddress(rs.getString("address"));
        account.setMfo(rs.getInt("mfo"));
        account.setMain(rs.getBoolean("ismain"));
        return account;
    }
}
