package gou.xuming.entity.mongo.role;

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
 * @Date: 2024:11:10 16:07
 * @Version: 1.0
 * @Description: TODO
 **/
@Document("sword")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sword implements Serializable {

    private static final long serialVersionUID = -3258839839160856613L;

    @MongoId
    private String id;

    private String name;

    private Integer age;

    private String sex;

    private String address;

    private LocalDateTime createTime = LocalDateTime.now();
}
