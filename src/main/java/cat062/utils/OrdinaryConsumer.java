package cat062.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cat062.decoder.CAT062Data;
import cat062.decoder.CAT062KafkaMsgNew;
import cat062.decoder.CommonUtil;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * 单线程Consumer
 */
public class OrdinaryConsumer {

    private static final Logger log = LoggerFactory.getLogger(OrdinaryConsumer.class);

    private final Consumer<String, String> consumer;

    // 用于测试的消息数量
    private final int expectedCount;

    public OrdinaryConsumer(String brokerId, String topic, String groupID, int expectedCount) {
        Properties props = new Properties();
        props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerId);
        props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupID);
        props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(topic));
        this.expectedCount = expectedCount;
    }

    public OrdinaryConsumer(KafkaConsumer consumer, int expectedCount) {

        this.consumer = consumer;

        this.expectedCount = expectedCount;
    }


    public void run() {
        try {

            int alreadyConsumed = 0;

            while (alreadyConsumed < expectedCount) {

                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(10));

                alreadyConsumed += records.count();

                records.forEach(this::handleRecord);
            }
        } finally {
            consumer.close();
        }
    }

    private void handleRecord(ConsumerRecord<String, String> record) {
//        try {
//            // 模拟每条消息10毫秒处理
//            Thread.sleep(ThreadLocalRandom.current().nextInt(10));
//
//        } catch (InterruptedException ignored) {
//            Thread.currentThread().interrupt();
//        }

        String kafkaMsgStr = record.value();

        CAT062KafkaMsgNew cAT062KafkaMsg = JSONObject.parseObject(kafkaMsgStr,CAT062KafkaMsgNew.class);

        String data = cAT062KafkaMsg.getData().getData().getValue();

//        String strAfterBase64Decode = new String(Base64.decodeBase64(data));

        int[] bytesInt = CommonUtil.base64ToIntArray(data);


        try {
            CAT062Data cAT062Data = new CAT062Data(bytesInt, 0, cAT062KafkaMsg.getDataLength(), cAT062KafkaMsg.getReceiveTime());

            log.info(JSON.toJSONString(cAT062Data));
            log.debug(cAT062Data.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info(Thread.currentThread().getName() + " finished message processed. Record offset = " + record.offset());
    }

}
