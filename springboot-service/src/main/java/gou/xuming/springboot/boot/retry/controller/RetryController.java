package gou.xuming.springboot.boot.retry.controller;

import gou.xuming.common.api.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xuming
 * @Date: 2024:12:11 22:37
 * @Version: 1.0
 * @Description: TODO
 **/
@RestController
@RequestMapping("retry")
public class RetryController {


    @RequestMapping("/test")
    public Result<String> test() {
        return Result.success("success");
    }
}
