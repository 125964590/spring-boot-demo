package top.jbzm.rabbitmq.sender;

/**
 * data process parent
 *
 * @author jbzm
 * @date 2019-05-15 16:41
 **/
public interface DataProcessHandler {

    /**
     * handle data export
     * @param dataProcessEvent base event
     */
    void handle(DataProcessEvent dataProcessEvent);
}