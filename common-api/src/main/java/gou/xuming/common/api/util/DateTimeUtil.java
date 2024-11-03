package gou.xuming.common.api.util;

import gou.xuming.common.api.singleton.DateTimeSingleton;

import java.time.LocalDateTime;

/**
 * @Author: xuming
 * @Date: 2024:11:03 12:30
 * @Version: 1.0
 * @Description: TODO
 **/
public class DateTimeUtil {


    public static String getNow() {
        return LocalDateTime.now().format(DateTimeSingleton.getDateTimeFormatter());
    }


}
