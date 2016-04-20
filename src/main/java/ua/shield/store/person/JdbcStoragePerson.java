package ua.shield.store.person;

import ua.shield.models.Account;
import ua.shield.models.Person;
import ua.shield.models.Post;
import ua.shield.store.JdbcStorageBeen;
import ua.shield.store.StorageBeen;
import ua.shield.store.post.JdbcStoragePost;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sa on 20.04.16.
 */
public class JdbcStoragePerson extends JdbcStorageBeen<Person> implements StorageBeen<Person> {
    final StorageBeen<Post> storagePost = new JdbcStoragePost();

    @Override
    protected Person generateBeen(ResultSet rs) throws SQLException {
        Person person = new Person();
        person.setUid(rs.getInt("uid"));
        person.setName(rs.getString("name"));
        person.setFullName(rs.getString("fullname"));
        person.setPost(storagePost.getBeenById(rs.getInt("post_id")));
        return person;
    }

    @Override
    public void updateBeen(Person been) {

    }

    @Override
    public void addBeen(Person been) {

    }
}
