package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FileTime {
    public static void FileTimeToTime(String FileTime){
        long time = Long.parseLong(FileTime, 16);
        long milliseconds = time / 10000;
        System.out.println(milliseconds);

        Calendar c1601 = Calendar.getInstance();
        c1601.set(Calendar.YEAR, 1601);
        c1601.set(Calendar.MONTH, Calendar.JANUARY);
        c1601.set(Calendar.DAY_OF_MONTH, 1);
        c1601.set(Calendar.HOUR, 0);
        c1601.set(Calendar.MINUTE, 0);
        c1601.set(Calendar.SECOND, 0);
        c1601.set(Calendar.MILLISECOND, 0);
        long interval = -c1601.getTimeInMillis();
        System.out.println(interval);

        Date date = new Date(milliseconds - interval);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(date);

        System.out.println("转换后的日期: " + formattedDate);
    }
}
