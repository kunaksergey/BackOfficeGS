package ua.shield.models;

/**
 * Created by sa on 14.04.16.
 * Спарочник должностей
 */
public class Post {
    int uid;
    String name;

    public Post() {
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
}
