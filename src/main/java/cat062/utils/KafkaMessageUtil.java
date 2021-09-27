
package cat062.utils;

import cat062.conf.KafkaProperties;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 */
public class KafkaMessageUtil {

    private static final Logger log = LoggerFactory.getLogger(KafkaMessageUtil.class);

    public static KafkaProducer<String, String> createKafkaProducer(KafkaProperties kProp) {
        KafkaProducer<String, String> kafkaProducer = null;
        try {
            Properties kafkaProp = assignProducerProperties(kProp);
            if (kafkaProp == null) {
                log.debug("kafka配置为空");
            } else {
                log.debug("kafka的配置，username:{},password:{}", kProp.username, kProp.password);
            }
            logProperties(kafkaProp);
            Enumeration<Object> e = kafkaProp.elements();
            while (e.hasMoreElements()) {
                log.debug("{}", e.nextElement());
            }
            kafkaProducer = new KafkaProducer<String, String>(kafkaProp);
        } catch (Exception e1) {
            log.debug("kafkaProducer生成报错{}", e1.getMessage());
            e1.printStackTrace();
        }
        return kafkaProducer;
    }

    public static KafkaConsumer<String, String> createKafkaConsumer(KafkaProperties kProp) {
        Properties kafkaProp = assignConsumerProperties(kProp);

        return new KafkaConsumer<String, String>(kafkaProp);
    }

    private static Properties assignConsumerProperties(KafkaProperties kProp) {
        Properties kafkaProp = assignCommonProperties(kProp);
        if (kafkaProp == null) {
            return null;
        }
        if (kProp.clientId != null) {
            kafkaProp.put(ConsumerConfig.GROUP_ID_CONFIG, kProp.clientId);
        }
        if (kProp.autoOffsetReset != null) {
            kafkaProp.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kProp.autoOffsetReset);
        }

        if (kProp.sessionTimeout != 0) {
            kafkaProp.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, kProp.sessionTimeout);
        }
        if (kProp.maxPollRecords != 0) {
            kafkaProp.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, kProp.maxPollRecords);
        }

        kafkaProp.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, kProp.enableAutoCommit);
        if (kProp.receiveBufferBytes != 0) {
            kafkaProp.put(ConsumerConfig.RECEIVE_BUFFER_CONFIG, kProp.receiveBufferBytes);
        }
        if (kProp.requestTimeoutMs != 0) {
            kafkaProp.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, kProp.requestTimeoutMs);
        }

        if (kProp.requestTimeoutMs != 0) {
        kafkaProp.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG,kProp.maxRequestSize);
        }

        kafkaProp.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProp.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");

        return kafkaProp;
    }

    private static Properties assignProducerProperties(KafkaProperties kProp) {
        Properties kafkaProp = assignCommonProperties(kProp);
        if (kafkaProp == null) {
            return null;
        }
        if (kProp.clientId != null) {
            kafkaProp.put(ProducerConfig.CLIENT_ID_CONFIG, kProp.clientId);
        }
        if (kProp.acks != null) {
            kafkaProp.put(ProducerConfig.ACKS_CONFIG, kProp.acks);
        }
        if (kProp.bufferMemory != 0) {
            kafkaProp.put(ProducerConfig.BUFFER_MEMORY_CONFIG, kProp.bufferMemory);
        }
        if (kProp.retries != 0) {
            kafkaProp.put(ProducerConfig.RETRIES_CONFIG, kProp.retries);
        }
        if (kProp.batchSize != 0) {
            kafkaProp.put(ProducerConfig.BATCH_SIZE_CONFIG, kProp.batchSize);
        }
        if (kProp.lingerMs != 0) {
            kafkaProp.put(ProducerConfig.LINGER_MS_CONFIG, kProp.lingerMs);
        }
        if (kProp.requestTimeoutMs != 0) {
            kafkaProp.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, kProp.requestTimeoutMs);
        }
        if (kProp.maxInFlightRequestPerConnection != 0) {
            kafkaProp.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION,
                    kProp.maxInFlightRequestPerConnection);
        }
        if (kProp.retryBackoffMs != 0) {
            kafkaProp.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, kProp.retryBackoffMs);
        }
//        if (kProp.maxRequestSize != 0) {
//            kafkaProp.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, kProp.maxRequestSize);
//        }


        kafkaProp.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, kProp.idempotence);
        kafkaProp.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProp.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");

        return kafkaProp;
    }

    private static Properties assignCommonProperties(KafkaProperties kProp) {
        Properties kafkaProp = new Properties();
        if (kProp.bootstrapServers == null) {
            return null;
        }
        kafkaProp.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, kProp.bootstrapServers);

        if (kProp.securityProtocol != null) {
            kafkaProp.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, kProp.securityProtocol);
            kafkaProp.put(SaslConfigs.SASL_MECHANISM, kProp.saslMechanism);

            String saslJaasConfig = String.format("%s required username=\"%s\" password=\"%s\";",
                    kProp.saslJaasModule, kProp.username, kProp.password);
            log.debug("SaslJaasConfig: [{}]", saslJaasConfig);

            kafkaProp.put(SaslConfigs.SASL_JAAS_CONFIG, saslJaasConfig);
        }

        return kafkaProp;
    }

    private static void logProperties(Properties kafProp) {
        for (Map.Entry<Object, Object> entry : kafProp.entrySet()) {
            if (entry.getKey() instanceof String) {
                String k = (String) entry.getKey();
                log.debug("Key: [{}] - Value: [{}]", k, kafProp.get(k));
            } else {
                log.error("在Kafka properties中设置的属性的Key必须是字符串。");
            }
        }
    }
}
