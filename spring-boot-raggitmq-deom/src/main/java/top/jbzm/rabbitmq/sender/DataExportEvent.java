package top.jbzm.rabbitmq.sender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataExportEvent extends DataProcessEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DataExportEvent(Object source) {
        super(source);
    }

    public DataExportEvent() {
        super("null");
    }
}
