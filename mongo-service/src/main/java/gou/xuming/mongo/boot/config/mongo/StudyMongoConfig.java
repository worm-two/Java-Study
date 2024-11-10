package gou.xuming.mongo.boot.config.mongo;


import cn.hutool.core.annotation.Alias;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mapping.model.SnakeCaseFieldNamingStrategy;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * @Author: xuming
 * @Date: 2024:10:27 12:53
 * @Version: 1.0
 * @Description: TODO
 **/
// @Configuration
public class StudyMongoConfig extends AbstractMongoConfig {

    private final static String STUDY = "study";


    @Alias(STUDY)
    @ConfigurationProperties(prefix = "spring.data.mongodb.study")
    public MongoProperties mongoProperties() {
        return new MongoProperties();
    }


    public StudyMongoConfig(@Qualifier(STUDY) MongoProperties mongoProperties) {
        super(mongoProperties);
    }

    @Override
    public MongoTemplate mongoTemplate(@Qualifier(STUDY) MongoDatabaseFactory factory) {

        DbRefResolver defaultDbRefResolver = new DefaultDbRefResolver(factory);
        MongoMappingContext mongoMappingContext = new MongoMappingContext();
        mongoMappingContext.setFieldNamingStrategy(new SnakeCaseFieldNamingStrategy());
        mongoMappingContext.setAutoIndexCreation(true);
        MappingMongoConverter converter = new MappingMongoConverter(defaultDbRefResolver, mongoMappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        return new MongoTemplate(factory, converter);
    }


    @Alias(STUDY)
    @Override
    public MongoDatabaseFactory mongoDatabaseFactory(@Qualifier(STUDY) MongoProperties mongoProperties) {
        return new SimpleMongoClientDatabaseFactory(mongoProperties().getUri());
    }
}
