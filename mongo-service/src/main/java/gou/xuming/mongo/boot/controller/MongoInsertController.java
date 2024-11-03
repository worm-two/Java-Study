package gou.xuming.mongo.boot.controller;

import gou.xuming.common.api.result.Result;
import gou.xuming.entity.mongo.cat.Person;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: xuming
 * @Date: 2024:10:27 12:54
 * @Version: 1.0
 * @Description: TODO
 **/
@RestController
@RequestMapping("java/study/mongo/person")
public class MongoInsertController {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private MongoRepository<Person, String> personMongoRepository;


    @PostMapping("/insert")
    public Result insert(@RequestBody Person person) {
        mongoTemplate.insert(person);
        return Result.success();

    }

    @GetMapping("/query")
    public Result<List<Person>> query() {
        List<Person> all = personMongoRepository.findAll();
        return Result.success(all);
    }

    @RequestMapping("/one")
    public void insertOne() {
    }

    @RequestMapping("/many")
    public void insertMany() {
    }

}
