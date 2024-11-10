package gou.xuming.mongo.boot.config.mongo;


import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mapping.model.SnakeCaseFieldNamingStrategy;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * @Author: xuming
 * @Date: 2024:10:27 12:53
 * @Version: 1.0
 * @Description: TODO
 **/
@Configuration
public class DefaultMongoConfig extends AbstractMongoConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.data.mongodb.study")
    public MongoProperties mongoProperties() {
        return new MongoProperties();
    }

    @Bean
    @Override
    public MongoDatabaseFactory mongoDatabaseFactory(MongoProperties mongoProperties) {
        return new SimpleMongoClientDatabaseFactory(mongoProperties().getUri());
    }

    @Bean
    @Override
    public MongoTemplate mongoTemplate(MongoDatabaseFactory factory) {

        MongoTemplate mongoTemplate = new MongoTemplate(factory);

        // 去除_class
        MappingMongoConverter mongoTemplateConverter = (MappingMongoConverter) mongoTemplate.getConverter();
        mongoTemplateConverter.setTypeMapper(new DefaultMongoTypeMapper(null));

        // 驼峰映射  自动创建索引
        MongoMappingContext mongoMappingContext = (MongoMappingContext) mongoTemplateConverter.getMappingContext();
        mongoMappingContext.setFieldNamingStrategy(new SnakeCaseFieldNamingStrategy());
        mongoMappingContext.setAutoIndexCreation(true);

        return mongoTemplate;
    }

}
