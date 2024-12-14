package gou.xuming.common.api.entity;

import lombok.Data;

/**
 * @Author: xuming
 * @Date: 2024:10:26 17:12
 * @Version: 1.0
 * @Description: 分页
 **/
@Data
public class Page {

    /**
     * 第几页，默认第一页
     */
    private Integer pageSize = 1;

    /**
     * 每页条数,默认20条
     */
    private Integer pageNumber = 10;

}
