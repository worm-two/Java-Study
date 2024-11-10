package gou.xuming.mongo.boot.config.mongo;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @Author: xuming
 * @Date: 2024:11:10 11:51
 * @Version: 1.0
 * @Description: TODO
 **/
public abstract class AbstractMongoConfig {

    private final MongoProperties mongoProperties;

    public AbstractMongoConfig(MongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    public abstract MongoTemplate mongoTemplate(MongoDatabaseFactory factory);

    public abstract MongoDatabaseFactory mongoDatabaseFactory(MongoProperties mongoProperties);

}
