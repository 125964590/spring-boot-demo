package top.zhengyiwoaini.webflux.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author jbzm
 * @date 2019-09-23 21:33
 */
@Slf4j
@RestController
@RequestMapping("test")
public class TestController {
  @GetMapping("test01")
  public Mono<String> test01() {
    return Mono.create(
        (x) -> {
            log.info("lol");
          x.success("lol");
        });
  }
}
