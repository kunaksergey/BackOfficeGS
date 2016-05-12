package ua.shield.models;

import org.hibernate.annotations.CascadeType;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hibernate.annotations.CascadeType.*;

/**
 * Created by sa on 13.04.16.
 * Класс компания
 *
 * @uid - компании
 * @name -наименование компании
 * @fullName - полное наименование компании
 * @edrpou - ЕДРПОУ компании
 * @inn - ИНН компании
 * @adress -адресс компании
 * @currentAccount -текущий счет компании
 * @supervisor - директор компании
 */
public class Company {
    private int uid;
    private String name;
    private String fullName;
    private String edrpou;
    private String inn;
    private String address;
    private List<Account> accountList;
    private Set<Account> accountSet;
    private Person supervisor;

    public Company() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int id) {
        this.uid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(String edrpou) {
        this.edrpou = edrpou;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Account> getAccountSet() {
        return accountSet;
    }

    public void setAccountSet(Set<Account> accountSet) {
        this.accountSet = accountSet;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList.addAll(accountList);
    }

    public void setAccountList(Account account) {
        this.accountList.add(account);
    }

    public Account getMainAccount() {
        for (Account account : accountSet) {
            if (account.isMain()) return account;
        }
        return null;
    }

    public Person getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Person supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Кампания:\n");
        str.append(name.trim()).append("\n").append(fullName.trim()).append("\n");
        str.append(supervisor.toString()).append("\n");
        for (Account account : accountSet) {
            str.append(account.toString());
        }
        return str.toString();
    }
}
