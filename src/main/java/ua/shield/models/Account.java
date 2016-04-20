package ua.shield.models;

/**
 * Created by sa on 14.04.16.
 * Cчет банка
 *
 * @uid - id Аккаунта
 * @number - номер счета
 * @nameBank -наименования банка
 * @mfo - мфо банка
 */
public class Account {
    int uid;
    int parentUid;
    String number;
    String nameBank;
    int mfo;
    String address;
    boolean isMain;

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

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }
}
