package com.abin.lee.kafka.consumer.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;

/**
 * Created by abin on 2017/3/28 19:06.
 * kafka-svr
 * com.abin.lee.kafka.consumer.listener
 */
public class KafkaConsumerServer  implements MessageListener<Integer, String> {
    protected final Logger LOG = LoggerFactory.getLogger("kafkaConsumer");
    /**
     * 监听器自动执行该方法
     *     消费消息
     *     自动提交offset
     *     执行业务代码
     *     （high level api 不提供offset管理，不能指定offset进行消费）
     */
    @Override
    public void onMessage(ConsumerRecord<Integer, String> record) {
        LOG.info("=============kafkaConsumer开始消费=============");
        String topic = record.topic();
        Integer key = record.key();
        String value = record.value();
        long offset = record.offset();
        int partition = record.partition();
        LOG.info("-------------topic:"+topic);
        LOG.info("-------------value:"+value);
        LOG.info("-------------key:"+key);
        LOG.info("-------------offset:"+offset);
        LOG.info("-------------partition:"+partition);
        LOG.info("~~~~~~~~~~~~~kafkaConsumer消费结束~~~~~~~~~~~~~");
    }

}