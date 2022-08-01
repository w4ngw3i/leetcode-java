package com.wangwei.test.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;

/**
 * @author wangwei
 * @version 1.0
 * @date 2021-08-30 11:19
 */
public class DateUtils {
    public static void main(String[] args) {
        String format = LocalDate.now().minusMonths(1).withDayOfMonth(15).format(DateTimeFormatter.ISO_LOCAL_DATE);
        String format2 = LocalDate.now().minusMonths(2).minusDays(15).format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(format2);
        String format3 = LocalDate.now().minusMonths(3).minusDays(15).format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(format3);
        String format4 = LocalDate.now().minusMonths(4).minusDays(15).format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(format4);
    }
}
