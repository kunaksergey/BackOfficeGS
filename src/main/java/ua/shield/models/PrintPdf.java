package ua.shield.models;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by sa on 15.04.16.
 */
public class PrintPdf {

    public PrintPdf() {
    }

    public void printPdfInvoice(Invoice doc) throws FileNotFoundException, DocumentException {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("ITextTest.pdf"));

        document.open();
        Anchor anchorTarget = new Anchor("First page of the document.");
        anchorTarget.setName("BackToTop");
        Paragraph paragraph1 = new Paragraph();

        paragraph1.setSpacingBefore(50);

        paragraph1.add(anchorTarget);

        document.add(paragraph1);
        FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 255, 0, 0));
        //java.io
        document.close();
    }

}
