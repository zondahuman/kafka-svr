package com.abin.lee.kafka.procuder.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by abin on 2017/3/28 19:06.
 * kafka-svr
 * com.abin.lee.kafka.consumer.listener
 */
@Service
public class KafkaProducerService {
    protected final Logger LOGGER = LoggerFactory.getLogger("KafkaProducerService");

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    /**
     * 向kafka里写数据.<br/>
     * @author miaohongbin
     * Date:2016年6月24日下午6:22:58
     */
    public void send(String message){
        LOGGER.info("message={}", message +"---------------------start-------");
        kafkaTemplate.sendDefault(ThreadLocalRandom.current().nextInt(), message);
        LOGGER.info("message={}", message +"---------------------end-------");
    }

}