package gou.xuming.entity.mongo.puppet;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

/**
 * @Author: xuming
 * @Date: 2024:12:14 20:47
 * @Version: 1.0
 * @Description: TODO
 **/
@Data
@Document("puppet_role")
public class PuppetRole {

    /**
     * 自增主键
     */
    @MongoId
    private ObjectId id;

    /**
     * 布袋戏类型:金光布袋戏,霹雳布袋戏
     */
    private String type;

    /**
     * 角色登场作品
     */
    private String appearance;

    /**
     * 角色名字
     */
    private String name;

    /**
     * 别名
     */
    private String alias;

    /**
     * 其他名称
     */
    private List<String> otherName;

    /**
     * 性别
     */
    private String gender;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 所属组织
     */
    private String organization;

    /**
     * 拥有的武器
     */
    private List<String> weapon;

    /**
     * 朋友
     */
    private List<String> friend;

    /**
     * 所有物
     */
    private List<String> belongings;

    /**
     * 诗号
     */
    private List<String> poem;

    /**
     * 根据地
     */
    private List<String> address;

    /**
     * 语录
     */
    private List<String> analects;


    /**
     * 经历
     */
    private List<String> experience;


}
