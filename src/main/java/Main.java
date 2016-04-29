import ua.shield.models.Company;
import ua.shield.store.company.HibernateStorageCompany;

/**
 * Created by sa on 29.04.16.
 */
public class Main {
    public static void main(String[] args) {
        HibernateStorageCompany storageCompany = new HibernateStorageCompany();
        for (Company company : storageCompany.getCompanyList()) {
            System.out.println(company.getName() + ":" + company.getFullName());
        }
    }
}
