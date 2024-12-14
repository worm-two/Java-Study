package gou.xuming.entity.mongo.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: xuming
 * @Date: 2024:10:27 20:18
 * @Version: 1.0
 * @Description: TODO
 **/
@Document("person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements Serializable {


    private static final long serialVersionUID = -3258839839160856613L;

    /**
     * 使用@Id注解指定MongoDB中的 _id 主键
     */
    @MongoId
    private String id;

    private String userName;

    private String passWord;

    private Integer age;

    /**
     * 创建一个5秒之后文档自动删除的索引
     */
    private LocalDateTime createTime = LocalDateTime.now();
}