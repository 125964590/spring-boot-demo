package top.jbzm.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhengyi
 * @date 2018/9/9 1:06 AM
 **/
public class lol {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        UserInfo build = UserInfo.builder().name("jbzm").password("jbzm").username("jbzm").phone(123423134L).build();
        ResponseEntity<ResponseData> responseDataResponseEntity = restTemplate.postForEntity("http://localhost:11195/uc/register", build, ResponseData.class);
        System.out.println(responseDataResponseEntity.toString());
    }

}