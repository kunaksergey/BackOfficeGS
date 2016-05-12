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
    private int uid;
    private String name;
    private String fullName;
    private Post post;

    public Person() {
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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(name.trim()).append(" : ").append(fullName.trim()).append("\n");
        return str.toString();
    }
}
