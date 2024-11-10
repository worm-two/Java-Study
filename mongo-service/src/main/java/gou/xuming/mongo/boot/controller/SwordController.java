package gou.xuming.mongo.boot.controller;

import gou.xuming.common.api.result.Result;
import gou.xuming.entity.mongo.person.Person;
import gou.xuming.entity.mongo.role.Sword;
import gou.xuming.mongo.boot.config.mongo.PuppetMongoConfig;
import gou.xuming.mongo.boot.dao.repository.puppet.SwordRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: xuming
 * @Date: 2024:10:27 12:54
 * @Version: 1.0
 * @Description: TODO
 **/
@RestController
@RequestMapping("java/study/mongo/sword")
public class SwordController {

    @Resource(name = PuppetMongoConfig.MONGO_TEMPLATE)
    private MongoTemplate mongoTemplate;

    @Resource
    private SwordRepository swordRepository;


    @PostMapping("/insert")
    public Result insert(@RequestBody Sword sword) {

        swordRepository.insert(sword);

        return Result.success();

    }

    @GetMapping("/query")
    public Result<List<Person>> query() {

        return Result.success();
    }

    @RequestMapping("/one")
    public Result insertOne() {

        Sword sword = Sword.builder().name("佛剑分说").age(40).sex("男").address("大雪原").createTime(LocalDateTime.now()).build();

        swordRepository.insert(sword);

        return Result.success();
    }

    @RequestMapping("/many")
    public void insertMany() {
    }

}
