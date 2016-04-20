package ua.shield.servlets.invoice;


import ua.shield.models.Invoice;
import ua.shield.store.invoice.InvoiceCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sa on 18.04.16.
 */
public class InvoiceViewServlet extends HttpServlet {
    private final InvoiceCache INVOICE_CACHE = InvoiceCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("uid") != null) {
            Invoice invoice = INVOICE_CACHE.getBeenById(Integer.parseInt(req.getParameter("uid")));
            req.setAttribute("invoice", invoice);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/invoice/InvoiceView.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("invoices", INVOICE_CACHE.getBeenList());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/invoice/InvoiceViewList.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
