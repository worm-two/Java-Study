package gou.xuming.mongo.boot.dao.repository.study;

import gou.xuming.entity.mongo.person.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: xuming
 * @Date: 2024:10:27 19:28
 * @Version: 1.0
 * @Description: TODO
 **/
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

}
