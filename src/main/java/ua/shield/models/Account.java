package ua.shield.models;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by sa on 14.04.16.
 * Cчет банка
 *
 * @uid - id Аккаунта
 * @parentUid -id родителя счета
 * @number - номер счета
 * @nameBank -наименования банка
 * @mfo - мфо банка
 */
public class Account {
    private int uid;
    private int parentUid;
    private Company company;
    private String number;
    private String nameBank;
    private int mfo;
    private String address;
    private boolean isMain;

    public Account() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getParentUid() {
        return parentUid;
    }

    public void setParentUid(int parentUid) {
        this.parentUid = parentUid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public int getMfo() {
        return mfo;
    }

    public void setMfo(int mfo) {
        this.mfo = mfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getIsMain() {
        return isMain;
    }
    public boolean isMain() {
        return isMain;
    }

    public void setIsMain(boolean main) {
        isMain = main;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;

        Account obj2 = (Account) obj;
        if (this.uid == obj2.getUid()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int tmp = 0;
        tmp = (uid + "").hashCode();
        return tmp;
    }

    @Override
    public String toString() {
        return "Счет: \n" +
                "ID=" + uid + "\n" +
                " PID компании=" + parentUid + "\n" +
                " номер='" + number + "\n" +
                " название банка='" + nameBank + "\n" +
                " МФО=" + mfo + "\n" +
                " Адресс='" + address.trim() + "\n" +
                " Основной :" + isMain + "\n" +
                company.getName();

    }
}
