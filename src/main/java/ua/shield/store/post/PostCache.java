package ua.shield.store.post;

import ua.shield.models.Post;
import ua.shield.store.Cache;

/**
 * Created by sa on 19.04.16.
 */
public class PostCache extends Cache<Post> {
    private static final PostCache INCTANCE = new PostCache();

    {
        storage = new JdbcStoragePost();
        //storage = new HibernateStoragePost();
    }

    private PostCache() {

    }

    static public PostCache getInstance() {
        return INCTANCE;
    }

}
