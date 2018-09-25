package top.jbzm.demo;

import lombok.Data;

/**
 * @author zhengyi
 * @date 2018/9/7 6:25 PM
 **/
@Data
public class ResponseData {
    private Object data;
    private Integer code;
    private Object message;
}