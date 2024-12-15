package gou.xuming.entity.mongo.puppet;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * @Author: xuming
 * @Date: 2024:12:14 21:03
 * @Version: 1.0
 * @Description: TODO
 **/
@Data
@Document("weapon_info")
public class WeaponInfo {

    /**
     * 自增主键
     */
    @MongoId
    private String id;

    /**
     * 武器名称
     */
    private String name;

    /**
     * 武器描述
     */
    private String description;

    /**
     * 武器拥有者
     */
    private String owner;


}
