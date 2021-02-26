package top.jzhp.kafka.a;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.Future;

public class Producer {

    private static Properties kafkaProps = new Properties();


    public static void main(String[] args) {
        kafkaProps.put("bootstrap.servers", "http://47.103.202.18:9092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        final KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProps);

        ProducerRecord<String, String> record = new ProducerRecord<>("test-topic", "Precision Products", "France");//Topic Key Value
        try{
            Future future = producer.send(record);
            future.get();//不关心是否发送成功，则不需要这行。
        } catch(Exception e) {
            e.printStackTrace();//连接错误、No Leader错误都可以通过重试解决；消息太大这类错误kafkaProducer不会进行任何重试，直接抛出异常
        }

    }
}
