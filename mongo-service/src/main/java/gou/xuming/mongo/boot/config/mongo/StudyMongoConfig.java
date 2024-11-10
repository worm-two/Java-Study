package gou.xuming.mongo.boot.config.mongo;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
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

    public static final String MONGO_PROPERTIES = STUDY + AbstractMongoConfig.MONGO_PROPERTIES;

    public static final String MONGO_TEMPLATE = STUDY + AbstractMongoConfig.MONGO_TEMPLATE;

    public static final String MONGO_DATABASE_FACTORY = STUDY + AbstractMongoConfig.MONGO_DATABASE_FACTORY;


    @Bean(MONGO_PROPERTIES)
    @ConfigurationProperties(prefix = "spring.data.mongodb.study")
    public MongoProperties mongoProperties() {
        return new MongoProperties();
    }

    @Primary
    @Bean(MONGO_DATABASE_FACTORY)
    @Override
    public MongoDatabaseFactory mongoDatabaseFactory(@Qualifier(MONGO_PROPERTIES) MongoProperties mongoProperties) {
        return new SimpleMongoClientDatabaseFactory(mongoProperties().getUri());
    }

    @Bean(MONGO_TEMPLATE)
    @Primary
    @Override
    public MongoTemplate mongoTemplate(@Qualifier(MONGO_DATABASE_FACTORY) MongoDatabaseFactory factory) {

        DbRefResolver defaultDbRefResolver = new DefaultDbRefResolver(factory);
        MongoMappingContext mongoMappingContext = new MongoMappingContext();
        mongoMappingContext.setFieldNamingStrategy(new SnakeCaseFieldNamingStrategy());
        mongoMappingContext.setAutoIndexCreation(true);
        MappingMongoConverter converter = new MappingMongoConverter(defaultDbRefResolver, mongoMappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        return new MongoTemplate(factory, converter);
    }

}
