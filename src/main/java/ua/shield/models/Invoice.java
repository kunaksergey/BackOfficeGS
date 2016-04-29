package ua.shield.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sa on 14.04.16.
 * Класс Invoice представляет собой класс описания счета
 *
 * @number - номер счета
 * @datInvoice - дата документа
 * @ourCompany - компания владелец
 * @clientCompany - компания клиент
 * @decription - описание счета
 * @sumNoNds - сумма без НДС
 * @nds - НДС
 * @sumNds - сумма с НДС
 * @countDetail - порядковый номер записи в детелизации счета
 */
public class Invoice {
    int uid;
    String number;
    Date date;
    Company ourCompany;
    Company clientCompany;
    String description;
    final EnumNds nds = EnumNds.NONDS;
    List<InvoiceDt> invoiceDtList = new ArrayList<>();
    private int countDetail = 0;
    InvoiceMemoryStream invoiceMemoryStream;

    public Invoice() {

    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Company getOurCompany() {
        return ourCompany;
    }

    public void setOurCompany(Company ourCompany) {
        this.ourCompany = ourCompany;
    }

    public Company getClientCompany() {
        return clientCompany;
    }

    public void setClientCompany(Company clientCompany) {
        this.clientCompany = clientCompany;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSumNoNds() {
        double sum = 0;
        for (InvoiceDt invoiceDt : invoiceDtList) {
            sum += invoiceDt.getSum();
        }
        return sum;
    }

    public double getNds() {
        return nds.getFactor();
    }

    public double getSumNds() {
        double sumTemp = getSumNoNds();
        return sumTemp + sumTemp * getNds();
    }

    public List<InvoiceDt> getInvoiceDtList() {
        return invoiceDtList;
    }

    public void setInvoiceDtList(List<InvoiceDt> invoiceDtList) {
        this.invoiceDtList = invoiceDtList;
    }

    public void setInvoiceDtList(InvoiceDt invoiceDtList) {
        this.invoiceDtList.add(invoiceDtList);
    }

    public int getCountDetail() {
        return countDetail;
    }

    public void setCountDetail(int countDetail) {
        this.countDetail = countDetail;
    }


    public String getDateLongString() {
        return Helper.getDateLongString(date);
    }


    public void removeRecordById(int id) {
        Iterator<InvoiceDt> iterator = invoiceDtList.iterator();
        while (iterator.hasNext()) {
            InvoiceDt o = iterator.next();
            if (o.getUid() == id) {
                iterator.remove();
            }
        }
    }


    /*************************************/


 /*   @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("Рахунок №").append(number).append("\n");
        str.append(date).append("\n");
        str.append("постачальник: ").append(ourCompany.getFullName()).append("\n");
        str.append("р/р ").append(ourCompany.getMainAccount().getNumber()).
                append(" в ").append(ourCompany.getMainAccount().getNameBank()).append("\n");
        str.append(ourCompany.getMainAccount().getMfo()).append("  ").append("ЄДРПОУ ").append(ourCompany.getEdrpou()).append("\n");
        str.append("Платник: ").append(clientCompany.getFullName()).append("\n");
        str.append("Призначення платежу: ").append(getDescription()).append("\n");

        int line = 0;

        for (InvoiceDt detail : invoiceDtList) {
            line++;
            str.append(line).append(" | ").append(detail.getUid()).append(" | ").append(detail.getDecription()).append(" | ").append(detail.getUnit().getName())
                    .append(" | ").append(detail.getAmount()).append(" | ").append(detail.getPrice()).append(" | ")
                    .append(detail.getSum()).append("\n");
        }
        str.append(" Разом без ПДВ ").append(getSumNoNds()).append("  ")
                .append(nds.getDescription()).append(" ").append(" Разом с ПДВ ").append(getSumNds()).append("\n\n");
        return str.toString();
    }*/


}
