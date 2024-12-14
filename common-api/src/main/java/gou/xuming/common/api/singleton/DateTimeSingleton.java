package gou.xuming.common.api.singleton;

import gou.xuming.common.api.pool.DateTimePool;

import java.time.format.DateTimeFormatter;

/**
 * @Author: xuming
 * @Date: 2024:11:03 12:41
 * @Version: 1.0
 * @Description: TODO
 **/
public class DateTimeSingleton {

    private final static DateTimeFormatter DATE = DateTimeFormatter.ofPattern(DateTimePool.DATE);

    private final static DateTimeFormatter TIME = DateTimeFormatter.ofPattern(DateTimePool.TIME);

    private final static DateTimeFormatter DATE_TIME = DateTimeFormatter.ofPattern(DateTimePool.DATE_TIME);

    public static DateTimeFormatter getDateFormatter() {
        return DATE;
    }

    public static DateTimeFormatter getTimeFormatter() {
        return TIME;
    }

    public static DateTimeFormatter getDateTimeFormatter() {
        return DATE_TIME;
    }


}
