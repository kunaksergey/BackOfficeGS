package ua.shield.store.post;

import ua.shield.models.Post;
import ua.shield.store.JdbcStorageBeen;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sa on 20.04.16.
 */
public class JdbcStoragePost extends JdbcStorageBeen<Post> {
    @Override
    protected Post generateBeen(ResultSet rs) throws SQLException {
        Post post = new Post();
        post.setUid(rs.getInt("uid"));
        post.setName(rs.getString("name"));
        return post;
    }

    @Override
    public void updateBeen(Post been) {

    }

    @Override
    public void addBeen(Post been) {

    }
}
