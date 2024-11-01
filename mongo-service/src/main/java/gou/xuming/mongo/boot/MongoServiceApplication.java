package gou.xuming.mongo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @Author: xuming
 * @Date: 2024:10:27 12:52
 * @Version: 1.0
 * @Description: Mongo 学习 启动类
 **/
@SpringBootApplication
@EnableMongoRepositories(basePackages ="gou.xuming.mongo.boot.repository")
public class MongoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoServiceApplication.class, args);
    }

}
