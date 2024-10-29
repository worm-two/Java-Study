package gou.xuming.kafka.boot.controller;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: xuming
 * @Date: 2024:10:06 12:41
 * @Version: 1.0
 * @Description: TODO
 **/
@RestController
@RequestMapping("kafka/producer")
public class kafkaProducer {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;


    @GetMapping("/kafka/normal/{message}")
    public void sendNormalMessage(@PathVariable("message") String message) {
        kafkaTemplate.send("sb_topic", message);
    }


    /**
     * 回调的第一种写法
     *
     * @param message
     */
    @GetMapping("/kafka/callbackOne/{message}")
    public void sendCallbackOneMessage(@PathVariable("message") String message) {
        kafkaTemplate.send("sb_topic", message).addCallback(new SuccessCallback<SendResult<String, Object>>() {
            // 成功的回调
            @Override
            public void onSuccess(SendResult<String, Object> success) {
                // 消息发送到的topic
                String topic = success.getRecordMetadata().topic();
                // 消息发送到的分区
                int partition = success.getRecordMetadata().partition();
                // 消息在分区内的offset
                long offset = success.getRecordMetadata().offset();
                System.out.println("发送消息成功1:" + topic + "-" + partition + "-" + offset);
            }
        }, new FailureCallback() {
            // 失败的回调
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送消息失败1:" + throwable.getMessage());
            }
        });
    }
}
