package gou.xuming.entity.mongo.cat;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

/**
 * @Author: xuming
 * @Date: 2024:10:27 19:25
 * @Version: 1.0
 * @Description: TODO
 **/
@Data
@Document("role")
public class Role implements Serializable {

    private static final long serialVersionUID = -3258839839160856613L;

    @MongoId
    private String id;

    private String name;

    private Integer age;

    private String sex;
}
