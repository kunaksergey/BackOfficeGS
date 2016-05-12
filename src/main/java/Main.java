import ua.shield.models.Account;
import ua.shield.models.Company;
import ua.shield.models.Person;
import ua.shield.models.Post;
import ua.shield.store.account.HibernateStorageAccount;
import ua.shield.store.company.HibernateStorageCompany;
import ua.shield.store.person.HibernateStoragePerson;
import ua.shield.store.post.HibernateStoragePost;

/**
 * Created by sa on 29.04.16.
 */
public class Main {
    public static void main(String[] args) {
        HibernateStoragePost storagePost = new HibernateStoragePost();
        System.out.println(storagePost.getPostById(7));
    }
}
