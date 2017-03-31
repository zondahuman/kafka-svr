package com.abin.lee.kafka.procuder.controller;

import com.abin.lee.kafka.procuder.service.KafkaProducerService;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by abin on 2017/3/31 2017/3/31.
 * kafka-svr
 * com.abin.lee.kafka.procuder.controller
 */
@Controller
public class KafkaController {
    private Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);


    @Resource
    KafkaProducerService kafkaProducerService;


    /**
     *
     * http://localhost:7200/send
     * http://localhost:8200/send
     * http://172.16.2.145:9600/send
     *
     * @return
     * @throws TException
     */
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    @ResponseBody
    public String send(String message) throws TException {
        LOGGER.info("message={}", message);
        String result = "SUCCESS";
        try {
            this.kafkaProducerService.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            result = "FAILURE";
        }
        return result;
    }



}
