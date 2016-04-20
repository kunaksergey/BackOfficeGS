package ua.shield.store.company;


import ua.shield.models.Account;
import ua.shield.models.Company;
import ua.shield.service.Settings;
import ua.shield.store.JdbcStorageBeen;
import ua.shield.store.StorageBeen;
import ua.shield.store.StorageBeenDt;
import ua.shield.store.account.JdbcStorageAccount;
import ua.shield.store.account.StorageAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by sa on 12.04.16.
 */
public class JdbcStorageCompany extends JdbcStorageBeen<Company> {

    final StorageBeenDt<Account> storageAccountList = new JdbcStorageAccount();

    @Override
    public void updateBeen(Company company) {
        try (
                final PreparedStatement preparedStatement =
                        this.connection.prepareStatement("UPDATE company SET name=(?),fullname=(?) where id=(?)")) {
            preparedStatement.setString(1, company.getName());
            preparedStatement.setString(2, company.getFullName());
            preparedStatement.setInt(3, company.getUid());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBeen(Company company) {
        try (
                final PreparedStatement preparedStatement =
                        this.connection.prepareStatement("INSERT INTO company (name, fullname) VALUES ((?),(?))")) {
            preparedStatement.setString(1, company.getName());
            preparedStatement.setString(2, company.getFullName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Company generateBeen(ResultSet rs) throws SQLException {
        Company company = new Company();

        company.setUid(rs.getInt("uid"));
        company.setName(rs.getString("name"));
        company.setFullName(rs.getString("fullname"));
        company.setEdrpou(rs.getString("edrpou"));
        company.setInn(rs.getString("inn"));
        company.setAddress(rs.getString("address"));
        company.setAccountList(storageAccountList.getBeenListDt(rs.getInt("uid")));
        return company;
    }

    private Account getMainAccount(List<Account> accountList) {
        for (Account account : accountList) {
            if (account.isMain())
                return account;
        }
        return null;
    }

}
