package top.jbzm.rabbitmq.sender;

/**
 * @author jbzm
 * @date 2019-05-15 16:42
 */
public abstract class AbstractDataProcessHandler implements DataProcessHandler {

    @Override
    public void handle(DataProcessEvent dataProcessEvent) {
        execute(dataProcessEvent);
    }

    abstract void execute(DataProcessEvent dataProcessEvent);
}
