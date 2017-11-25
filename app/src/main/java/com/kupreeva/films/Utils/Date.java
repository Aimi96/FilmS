package com.kupreeva.films.Utils;

/**
 * Created by mkmtst on 31.10.2017.
 */

import java.text.SimpleDateFormat;

public class Date {
    public static String DateToUTCString(java.util.Date date, String dataformat) {
        final SimpleDateFormat fmt = new SimpleDateFormat(dataformat);
        return fmt.format(date);
    }

}
