package gou.xuming.common.api.entity;

import lombok.Data;

/**
 * @Author: xuming
 * @Date: 2024:10:26 17:14
 * @Version: 1.0
 * @Description: 基础对象
 **/
@Data
public class BaseEntity {

    /**
     * 自增主键
     */
    private Long id;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long updateTime;

    /**
     * 逻辑删除
     */
    private Boolean isDelete;


}
