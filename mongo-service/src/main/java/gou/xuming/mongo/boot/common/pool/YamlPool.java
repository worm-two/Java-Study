package gou.xuming.mongo.boot.common.pool;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: xuming
 * @Date: 2024:11:02 20:20
 * @Version: 1.0
 * @Description: TODO
 **/
@Component
@Data
public class YamlPool {

    @Value("${date}")
    public String date;

    @Value("${time}")
    public String time;

    @Value("${datetime}")
    public String dateTime;

    @Value("${timezone}")
    public String timeZone;
}
