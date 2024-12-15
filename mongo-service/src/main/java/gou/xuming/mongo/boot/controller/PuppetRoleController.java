package gou.xuming.mongo.boot.controller;

import gou.xuming.common.api.result.Result;
import gou.xuming.entity.mongo.puppet.PuppetRole;
import gou.xuming.mongo.boot.config.mongo.PuppetMongoConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: xuming
 * @Date: 2024:12:14 21:39
 * @Version: 1.0
 * @Description: TODO
 **/
@RestController
@RequestMapping("/puppet/role")
@Slf4j
public class PuppetRoleController {

    @Resource(name = PuppetMongoConfig.MONGO_TEMPLATE)
    private MongoTemplate mongoTemplate;

    @PostMapping
    public Result createRole(@RequestBody PuppetRole puppetRole) {
        mongoTemplate.insert(puppetRole);
        return Result.success().message(puppetRole.getName() + "新增成功");
    }

    @GetMapping
    public Result<List<PuppetRole>> getRole() {
        List<PuppetRole> data = mongoTemplate.findAll(PuppetRole.class);
        return Result.success(data);
    }

}
