package com.abin.lee.kafka.procuder.controller.test;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
/**
 * Created by abin on 2017/4/1 16:02.
 * kafka-svr
 * com.abin.lee.kafka.procuder.controller.test
 */
public class KafkaProduceTest {

    public static void main(String[] args) {
        System.out.println("begin produce");
        connectionKafka();
        System.out.println("finish produce");
    }

    public static void connectionKafka() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "172.16.2.146:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<String, String>("anti_fraud", Integer.toString(i), Integer.toString(i)));
        }
        producer.close();
    }

}
