package ua.shield.models;

import javafx.scene.input.DataFormat;
import org.apache.commons.codec.digest.Sha2Crypt;
import ua.shield.service.Settings;

import java.lang.reflect.ParameterizedType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by sa on 14.04.16.
 */
public class Helper {
    public static String getNumberInvoice(Date date) {
        return new SimpleDateFormat("MMdd").format(date);
    }

    public static String getDateLongString(Date date) {
        Locale local = new Locale("uk", "UA");
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, local);
        return df.format(date);
    }

    public static String getShotDateInvoice(Date date) {
        Locale local = new Locale("uk", "UA");
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, local);
        return df.format(date);
    }


    public static String getGenericParameterClass(Class actualClass, int parameterIndex) {
        return ((Class) ((ParameterizedType) actualClass.getGenericSuperclass()).getActualTypeArguments()[parameterIndex]).getSimpleName().toLowerCase();
    }

    public static String getHashPassword(String passwd) {
        return Sha2Crypt.sha256Crypt(passwd.getBytes());
    }

}
