package top.jbzm.rabbitmq.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jbzm.rabbitmq.sender.Sender;

/**
 * @Author jbzm
 * @Date Create on 2018/3/18 1:03
 */
@RestController
public class MqTest {
    @Autowired
    private Sender sender;

    @GetMapping("test")
    public void test() {
        sender.send();
    }

}

