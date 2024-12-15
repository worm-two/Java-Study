package gou.xuming.mongo.boot.dao.repository.puppet;


import gou.xuming.entity.mongo.puppet.Sword;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: xuming
 * @Date: 2024:11:10 16:20
 * @Version: 1.0
 * @Description: TODO
 **/
@Repository
public interface SwordRepository extends MongoRepository<Sword, String> {


}
