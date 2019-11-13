package top.jbzm.annotationtest.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author jbzm
 * @date 2019-11-13 11:47
 */
@Component
public class PostProcess implements BeanPostProcessor {
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (beanName.equals("userTest")) {
      PropertiesConfig.User user = (PropertiesConfig.User) bean;
      System.out.println(user.toString());
    }
    return null;
  }
}
