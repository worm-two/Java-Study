package gou.xuming.mongo.boot.repository;

import gou.xuming.entity.mongo.cat.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: xuming
 * @Date: 2024:10:27 19:28
 * @Version: 1.0
 * @Description: TODO
 **/
public interface PersonRepository extends MongoRepository<Person, String> {

}
