package com.abin.lee.kafka.procuder.controller.test;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by abin on 2018/3/8 19:31.
 * rrd-verify
 * com.heika.rrd.kafka
 */
public class SearchConsumerMessage {
    public static void main(String[] args) {
        Properties props = new Properties();
//        props.put("bootstrap.servers", "hadoop-1:9092,hadoop-2:9092");
//        props.put("bootstrap.servers", "hadoop-1:9092,hadoop-2:9092,hadoop-3:9092");
        props.put("bootstrap.servers", "172.16.1.90:9092,172.16.1.91:9092,172.16.2.148:9092");
//        props.put("bootstrap.servers", "172.16.1.90:9092,172.16.1.91:9092");
        System.out.println("this is the group part test 1");
        //消费者的组id
        props.put("group.id", "info.search.org");//这里是GroupA或者GroupB

        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");

        //从poll(拉)的回话处理时长
        props.put("session.timeout.ms", "30000");
        //poll的数量限制
//       props.put("max.poll.records", "100");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        //订阅主题列表topic
//        consumer.subscribe(Arrays.asList("antifraud.websearch.result.test"));
        consumer.subscribe(Arrays.asList("babel.crawl.result.test"));
        System.out.printf("----------------------------start---------------------------------------------");
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                //　正常这里应该使用线程池处理，不应该在这里处理
                System.out.printf("-------offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value()+"\n");
//            System.out.printf("----------------------------end---------------------------------------------");

        }

    }

}
