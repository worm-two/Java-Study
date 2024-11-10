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

    public static final String MONGO_PROPERTIES = "MongoProperties";

    public static final String MONGO_TEMPLATE = "MongoTemplate";

    public static final String MONGO_DATABASE_FACTORY = "mongoDatabaseFactory";

    public abstract MongoDatabaseFactory mongoDatabaseFactory(MongoProperties mongoProperties);

    public abstract MongoTemplate mongoTemplate(MongoDatabaseFactory factory);

}
