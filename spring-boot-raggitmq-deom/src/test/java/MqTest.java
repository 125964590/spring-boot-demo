import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.jbzm.rabbitmq.sender.Sender;

/**
 * @Author jbzm
 * @Date Create on 2018/3/18 1:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MqTest {
    @Autowired
    private Sender sender;

    @Test
    public void test01(){
        sender.send();
    }

}

