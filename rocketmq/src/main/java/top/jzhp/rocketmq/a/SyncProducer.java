package top.jzhp.rocketmq.a;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

public class SyncProducer {

    public static void main(String[] args) throws Exception {

        // 创建生产者
        DefaultMQProducer producer = new DefaultMQProducer("test-group");
        // 地址namesrv地址
        producer.setNamesrvAddr("127.0.0.1:9876");
        // 启动服务
        producer.start();

        for (int i = 0; i < 100; i++) {
            Message msg = new Message("test-topic","TagA", ("Hello, " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg);
            System.out.println(sendResult);
        }

        producer.shutdown();
    }
}
