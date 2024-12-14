package gou.xuming.mongo.boot.config.mongo;

import cn.hutool.core.util.StrUtil;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;

/**
 * @Author: xuming
 * @Date: 2024:11:10 11:51
 * @Version: 1.0
 * @Description: TODO
 **/
public abstract class AbstractMongoConfig {

    public static final String MONGO_PROPERTIES = "MongoProperties";

    public static final String MONGO_TEMPLATE = "MongoTemplate";

    public static final String MONGO_DATABASE_FACTORY = "MongoDatabaseFactory";

    public abstract MongoDatabaseFactory mongoDatabaseFactory();

    public abstract MongoTemplate mongoTemplate();

    String getUri(MongoProperties mongoProperties) {

        // 数据库配置
        String host = mongoProperties.getHost();
        int port = mongoProperties.getPort();
        String username = mongoProperties.getUsername();
        String password = Arrays.toString(mongoProperties.getPassword());
        String database = mongoProperties.getDatabase();
        String authenticationDatabase = mongoProperties.getAuthenticationDatabase();

        // 参数校验
        if (StrUtil.isBlank(host)) {
            throw new IllegalArgumentException("Mongo host must not be null or empty");
        }
        if (port <= 0) {
            throw new IllegalArgumentException("Mongo port must be greater than 0");
        }
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            throw new IllegalArgumentException("Mongo username and password must not be null or empty");
        }
        if (StrUtil.isBlank(database)) {
            throw new IllegalArgumentException("Mongo database must not be null or empty");
        }


        return getUri(host, port, username, password, database, authenticationDatabase);
    }

    private String getUri(String host, int port, String username, String password, String database, String authenticationDatabase) {

        StringBuilder uri = new StringBuilder();
        uri.append("mongodb://");
        uri.append(username);
        uri.append(":").append(password);
        uri.append("@");
        uri.append(host).append(":").append(port).append("/").append(database);
        if (StrUtil.isNotBlank(authenticationDatabase)) {
            uri.append("?authSource=").append(authenticationDatabase).append("&authMechanism=SCRAM-SHA-1");
        }

        return uri.toString();
    }
}
