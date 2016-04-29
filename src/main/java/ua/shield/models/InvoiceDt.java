package ua.shield.models;

/**
 * Created by sa on 14.04.16.
 * Класс Invoice представляет собой класс описания счета
 *
 * @uid - id
 * @parentUid - id родителя
 * @decription - описание записи
 * @unit - класс единица измерения
 * @amount - описание счета
 * @price - цена без НДС
 * @sum - сумма записи без НДС
 **/
public class InvoiceDt {
    int uid;
    int parentUid;
    String decription;
    Unit unit;
    double amount;
    double price;
    double sum;

    public InvoiceDt() {

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

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }


}

