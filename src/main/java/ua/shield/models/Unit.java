package ua.shield.models;

/**
 * Created by sa on 14.04.16.
 */
public class Unit {
    private int uid;
    private String name;
    private String fullName;

    public Unit() {
    }

    public Unit(String name, String fullName) {
        this.name = name;
        this.fullName = fullName;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    @Override
    public String toString() {
        return "Тип " +
                "Id=" + uid +
                ", Имя :'" + name + '\'' +
                ", полное Имя :'" + fullName + "\n";

    }
}
