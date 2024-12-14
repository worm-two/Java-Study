package gou.xuming.common.api.exception;

/**
 * @Author: xuming
 * @Date: 2024:10:26 17:09
 * @Version: 1.0
 * @Description: 网关异常类
 **/
public class GateWayException extends RuntimeException {

    public GateWayException() {
        super();
    }

    public GateWayException(String message) {
        super(message);
    }
}
