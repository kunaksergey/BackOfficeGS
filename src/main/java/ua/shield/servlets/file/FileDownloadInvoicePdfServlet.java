package ua.shield.servlets.file;

import com.itextpdf.text.DocumentException;
import ua.shield.models.Invoice;
import ua.shield.models.InvoiceMemoryStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by sa on 26.04.16.
 */
@WebServlet("/FileDownloadServlet")
public class FileDownloadInvoicePdfServlet extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(); //получаем сессию
        Invoice invoice = (Invoice) session.getAttribute("invoice"); //получаем объект invoice из сесиии
        InvoiceMemoryStream invoiceMemoryStream = new InvoiceMemoryStream(invoice); // объект потока
        ByteArrayOutputStream outputStream = null;

        try (ServletOutputStream os = resp.getOutputStream()) {
            outputStream = invoiceMemoryStream.getOutputStreamPdf(); //получаем поток Pdf
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            resp.setContentType("application/pdf");
            resp.setContentLength(outputStream.size());
            resp.setHeader("Content-Disposition", "attachment; filename=\"invoice.pdf\"");

            /*Читаем из буфера и отправляем вывод клиенту*/
            byte[] bufferData = new byte[1024];
            int read = 0;
            while ((read = inputStream.read(bufferData)) != -1) {
                os.write(bufferData, 0, read);
            }

        } catch (DocumentException e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

    }
}
