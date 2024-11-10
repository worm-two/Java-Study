package gou.xuming.mongo.boot.config.global;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @Author: xuming
 * @Date: 2024:11:03 11:53
 * @Version: 1.0
 * @Description: TODO
 **/
@ComponentScan(basePackages = "gou.xuming.common.api")
@Configuration
public class GlobalScanConfig {
}
