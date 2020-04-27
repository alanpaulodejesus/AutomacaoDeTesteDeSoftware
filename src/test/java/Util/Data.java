package Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Data {

    public static String retornaDataAtual() {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return sdf.format(calendar.getTime());
    }
}
