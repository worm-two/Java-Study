package gou.xuming.common.api.util;

import gou.xuming.common.api.pool.DateTimePool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: xuming
 * @Date: 2024:11:03 12:30
 * @Version: 1.0
 * @Description: TODO
 **/
public class DateTimeUtil {


    public static DateTimeFormatter getDateTimeFormatter() {
        return DateTimeFormatter.ofPattern(DateTimePool.DATE_TIME);
    }

    public static DateTimeFormatter getDateTimeFormatter(String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }

    public static String getNow() {
        return LocalDateTime.now().format(getDateTimeFormatter());
    }


}
