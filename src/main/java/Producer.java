import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Producer {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Properties producerConfiguration = new Properties();
        producerConfiguration.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerConfiguration.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerConfiguration.put(ProducerConfig.CLIENT_ID_CONFIG, "top-articles-lambda-example-client");
        producerConfiguration.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(producerConfiguration);

        long counter = 0;
        while (true) {
            TimeUnit.SECONDS.sleep(1);
            ProducerRecord<String, String> record = new ProducerRecord<>("input", "1", Long.toString(counter++));
            System.out.println(record.toString());
            kafkaProducer.send(record).get();
        }
    }
}
