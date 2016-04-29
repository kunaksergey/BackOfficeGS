package ua.shield.servlets.invoice;

import ua.shield.models.Company;
import ua.shield.models.Invoice;
import ua.shield.store.company.CompanyCache;
import ua.shield.store.invoice.InvoiceCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sa on 22.04.16.
 */
@WebServlet(
        urlPatterns = "/invoice/add",
        initParams = @WebInitParam(name = "ourCompanyID", value = "1")
)
public class InvoiceAddServlet extends HttpServlet {
    private final InvoiceCache INVOICE_CACHE = InvoiceCache.getInstance();
    private final CompanyCache COMPANY_CACHE = CompanyCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Invoice invoice = null;
        int ourCompanyID = Integer.parseInt(getInitParameter("ourCompanyID"));
        try {
            invoice = INVOICE_CACHE.createBeen(); //создаем пустой объект Invoice
            invoice.setOurCompany(COMPANY_CACHE.getBeenById(ourCompanyID));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.setAttribute("invoice", invoice);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/invoice/InvoiceView.jsp");
        dispatcher.forward(req, resp);
    }
}
