package ua.shield.models;

/**
 * Created by sa on 14.04.16.
 * Класс - Персона
 *
 * @uid - id персоны
 * @name - имя персоны
 * @fullName - полное имя персоны
 * @post -должность
 */
public class Person {
    int uid;
    String name;
    String fullName;
    Post post;

    public Person() {
    }

    public Person(int uid, String name, String fullName, Post post) {
        this.uid = uid;
        this.name = name;
        this.fullName = fullName;
        this.post = post;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
