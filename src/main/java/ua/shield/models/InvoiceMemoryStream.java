package ua.shield.models;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.Path;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by sa on 26.04.16.
 */
public class InvoiceMemoryStream {
    Invoice invoice;
    String pathFont;

    {
        pathFont = this.getClass().getClassLoader().getResource("arial.ttf").getFile().toString();
    }


    public InvoiceMemoryStream(Invoice invoice) {
        this.invoice = invoice;
    }

    public ByteArrayOutputStream getOutputStreamPdf() throws DocumentException, IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4, 10, 10, 20, 20);
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        BaseFont font = BaseFont.createFont(pathFont, BaseFont.IDENTITY_H, BaseFont.EMBEDDED); //подключаем файл шрифта, который поддерживает кириллицу

        Font fontTitle = new Font(font, 12);
        Paragraph chapterTitle = new Paragraph("База Отдыха \"Золотые Пески\"", new Font(font, 8));
        chapterTitle.setAlignment(Element.ALIGN_RIGHT);
        Paragraph chapterSection = new Paragraph("Счет", fontTitle);
        chapterSection.setAlignment(Element.ALIGN_CENTER);

        Chapter chapter1 = new Chapter(chapterTitle, 1);
        chapter1.setNumberDepth(0);
        Section section = chapter1.addSection(chapterSection, 0);
        section.addAll(getTitle(font));
        section.add(getTable(font));
        document.open();
        document.add(chapter1);
        document.close();
        return outputStream;
    }

    //Генерация шапки
    java.util.List<Paragraph> getTitle(BaseFont font) throws DocumentException {
        Font fontTitle = new Font(font, 12);
        java.util.List<Paragraph> list = new ArrayList<>();
        list.add(new Paragraph("Рахунок " + invoice.getNumber(), fontTitle));
        list.add(new Paragraph(invoice.getDateLongString(), fontTitle));
        list.add(new Paragraph("Постачальник " + invoice.getOurCompany().getFullName(), fontTitle));
        Account ourAccount = invoice.getOurCompany().getMainAccount();
        list.add(new Paragraph("р/р " + ourAccount.getNumber()
                + "в " + ourAccount.getNameBank(), fontTitle));
        list.add(new Paragraph("МФО " + ourAccount.getMfo() + " ЕДРПОУ " + invoice.getOurCompany().getEdrpou(), fontTitle));
        list.add(new Paragraph("Платник " + invoice.getClientCompany().getFullName(), fontTitle));
        return list;
    }

    //Генерация таблицы
    PdfPTable getTable(BaseFont font) throws DocumentException {
        PdfPTable table = new PdfPTable(6);
        table.setSpacingBefore(15);
        table.setSpacingAfter(15);
        table.setWidthPercentage(90);
        float[] columnWidths = {10, 132, 16, 14, 20, 20};

        table.setWidths(columnWidths);
        PdfPCell cell;
        Font tableFont = new Font(font, 9);
        //ячейка с объединением из 3-ёх ячеек одной строки
        table.addCell(new PdfPCell(new Phrase("№пп", tableFont)));
        cell = new PdfPCell(new Phrase("Найменування товару", tableFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        table.addCell(new PdfPCell(cell));
        table.addCell(new PdfPCell(new Phrase("Од.", tableFont)));
        table.addCell(new PdfPCell(new Phrase("Кіль-ть", tableFont)));
        table.addCell(new PdfPCell(new Phrase("Ціна", tableFont)));
        table.addCell(new PdfPCell(new Phrase("Сумма", tableFont)));
        int count = 0;
        for (InvoiceDt dt : invoice.getInvoiceDtList()) {
            count++;
            table.addCell(new PdfPCell(new Phrase(String.valueOf(count), tableFont))); //№пп
            table.addCell(new PdfPCell(new Phrase(dt.getDecription(), tableFont)));//Наименування товару
            table.addCell(new PdfPCell(new Phrase(dt.getUnit().getFullName(), tableFont)));//Од.

            cell = new PdfPCell(new Phrase(String.format("%.1f", dt.getAmount()), tableFont));//Кількість
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.format("%.2f", dt.getPrice()), tableFont));//Ціна
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.format("%.2f", dt.getSum()), tableFont));//Сумма
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(cell);
        }

        //Подвал
        cell = new PdfPCell(new Phrase("Разом без ПДВ", tableFont));//Сумма без НДС
        cell.setColspan(5);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(String.format("%.2f", invoice.getSumNoNds()), tableFont));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("ПДВ", tableFont)); //НДС
        cell.setColspan(5);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(String.format("%.2f", invoice.getNds()), tableFont));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Разом з ПДВ", tableFont)); //Сумма с НДС
        cell.setColspan(5);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(String.format("%.2f", invoice.getSumNds()), tableFont));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setRowspan(2);
        table.addCell(cell);

        Font fontSumma = new Font(font, 9, Font.BOLD);
        cell = new PdfPCell(new Phrase("Тут будет сумма-----", fontSumma)); //Сумма прописью
        cell.setColspan(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        return table;
    }
}
