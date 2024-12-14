package gou.xuming.mongo.boot.controller;

import gou.xuming.common.api.result.Result;
import gou.xuming.entity.mongo.person.Person;
import gou.xuming.mongo.boot.dao.repository.study.PersonRepository;
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
public class PersonController {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private PersonRepository personRepository;


    @PostMapping("/insert")
    public Result insert(@RequestBody Person person) {
        mongoTemplate.insert(person);
        return Result.success();

    }

    @GetMapping("/query")
    public Result<List<Person>> query() {
        List<Person> all =  personRepository.findAll();
        return Result.success(all);
    }

    @RequestMapping("/one")
    public Result insertOne() {


        return Result.success();
    }

    @RequestMapping("/many")
    public Result insertMany() {

        return Result.success();
    }

}
