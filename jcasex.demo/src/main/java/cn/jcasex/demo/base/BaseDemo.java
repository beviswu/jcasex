package cn.jcasex.demo.base;

import cn.jcasex.demo.jdk.util.calendar.CalendarDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseDemo {
    protected  Logger logger = LoggerFactory.getLogger(getLoggerName());

    protected String getLoggerName() {
        return this.getClass().getSimpleName();
    }
}