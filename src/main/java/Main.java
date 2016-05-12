import ua.shield.models.*;
import ua.shield.store.Cache;
import ua.shield.store.account.HibernateStorageAccount;
import ua.shield.store.company.HibernateStorageCompany;
import ua.shield.store.invoice.HibernateStorageInvoice;
import ua.shield.store.invoice.HibernateStorageInvoiceDt;
import ua.shield.store.person.HibernateStoragePerson;
import ua.shield.store.post.HibernateStoragePost;
import ua.shield.store.unit.HibernateStorageUnit;
import ua.shield.store.unit.UnitCache;

/**
 * Created by sa on 29.04.16.
 */
public class Main {
    public static void main(String[] args) {
        Cache<Unit> cache = UnitCache.getInstance();
        for (Unit u : cache.getBeenList()) {
            System.out.println(u);
        }

  /*      Unit u=cache.getBeenById(1);
        System.out.println(u);
*/
    }
}
