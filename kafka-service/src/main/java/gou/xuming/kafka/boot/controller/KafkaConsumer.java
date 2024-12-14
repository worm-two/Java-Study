package gou.xuming.kafka.boot.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xuming
 * @Date: 2024:10:06 12:42
 * @Version: 1.0
 * @Description: TODO
 **/
@RestController
@RequestMapping("kafka/consumer")
public class KafkaConsumer {

    //监听消费
    @KafkaListener(topics = {"sb_topic"})
    public void onNormalMessage(ConsumerRecord<String, Object> record) {
        System.out.println("简单消费：" + record.topic() + "-" + record.partition() + "=" +
                record.value());
    }
}
