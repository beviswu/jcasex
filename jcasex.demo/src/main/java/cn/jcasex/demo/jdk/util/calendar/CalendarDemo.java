package cn.jcasex.demo.jdk.util.calendar;

import cn.jcasex.demo.base.BaseDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo extends BaseDemo {


    public static void main(String[] args) throws ParseException {
        //leapYearDemo1("20200330 20:21:22");
        CalendarDemo calendarDemo = new CalendarDemo();
        calendarDemo.leapYearDemo1("20200330 20:21:22");
        calendarDemo.leapYearDemo2("20200228 20:21:22");
    }

    public void leapYearDemo1(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

        Date date = sdf.parse(dateStr);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        logger.info("arguments[dateStr={}]", dateStr);
        logger.info("new SimpleDateFormat(\"yyyyMMdd HH:mm:ss\").format(\"{}\")={}", dateStr, sdf2.format(calendar1.getTime()));

        Calendar calendar2 = (Calendar) calendar1.clone();
        calendar2.add(Calendar.MONTH, -1);

        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        logger.info("(\"{}\").add(Calendar.MONTH,-1)={}", sdf3.format(calendar1.getTime()), sdf4.format(calendar2.getTime()));

    }

    public void leapYearDemo2(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

        Date date = sdf.parse(dateStr);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);

        Calendar calendar2 = (Calendar) calendar1.clone();
        calendar2.set(Calendar.DAY_OF_MONTH, calendar1.get(Calendar.DAY_OF_MONTH) + 2);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        logger.info("(\"{}\").set(Calendar.DAY_OF_MONTH, calendar1.get(Calendar.DAY_OF_MONTH) + 2)={}", sdf2.format(calendar1.getTime()),
                sdf3.format(calendar2.getTime()));
    }

    /**
     * �ж�ָ������Ƿ�������
     * @return ��Ӧָ������Ƿ�����
     */
     boolean isLeapYeah(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? true : false;
    }
}
