package ua.shield.store.post;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.shield.models.Post;
import ua.shield.store.HibernateStorageConnect;

import java.util.List;

/**
 * Created by sa on 12.05.16.
 */
public class HibernateStoragePost {
    private final SessionFactory factory = HibernateStorageConnect.getINSTANCE().getFactory();

    /* Method to  READ all the posts */
    public List<Post> getPostList() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            return session.createQuery("FROM Post").list();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            tx.commit();
            session.close();
        }
        return null;
    }

    public Post getPostById(int uid) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (Post) session.get(Post.class, uid);
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            tx.commit();
            session.close();
        }
        return null;
    }
}

