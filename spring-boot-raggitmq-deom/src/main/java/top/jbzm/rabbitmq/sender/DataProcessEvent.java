package top.jbzm.rabbitmq.sender;

import lombok.Getter;
import lombok.Setter;
import lombok.Synchronized;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * data base event
 *
 * @author jbzm
 * @date 2019-05-15 21:43
 */
@Getter
@Setter
@ToString
public class DataProcessEvent extends ApplicationEvent {

    private String taskId;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DataProcessEvent(Object source) {
        super(source);
    }

    public DataProcessEvent(){
        super("null");
    }

}
