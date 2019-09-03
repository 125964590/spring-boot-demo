package top.jbzm.rabbitmq.sender;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author jbzm
 * @date 2019-05-15 14:02
 */
@Component
public class MyListener implements ApplicationListener<DataProcessEvent>, InitializingBean {

    @Autowired(required = false)
    private List<DataProcessHandler> myHandlers;

    @Override
    public void onApplicationEvent(DataProcessEvent event) {
        myHandlers.forEach(handler -> handler.handle(event));
    }

    @Override
    public void afterPropertiesSet() {
        if (!CollectionUtils.isEmpty(myHandlers)) {
            AnnotationAwareOrderComparator.sort(myHandlers);
        }
    }
}
