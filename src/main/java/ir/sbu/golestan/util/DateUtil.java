package ir.sbu.golestan.util;

/**
 * Created by Ali Asghar on 23/06/2017.
 */

public class DateUtil {
    private static PersianCalendar pc = new PersianCalendar();
    public synchronized static int getYear(){
        return pc.getYear();
    }
}