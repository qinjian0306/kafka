package com.qj.kafka.controller;

import com.qj.kafka.bean.KafkaOrder;
import com.qj.kafka.kafka.KafkaInstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * kafka controller
 */
@RestController
public class KafkaController {

    @Autowired
    private KafkaInstant kafkaInstant;

    @RequestMapping("/kafka")
    public String sendKafkaOrder(){
        KafkaOrder kafkaOrder = new KafkaOrder();
        kafkaOrder.setCryptoCode("BTC");
        kafkaOrder.setExpireTime(System.currentTimeMillis());
        kafkaOrder.setCreateTime(System.currentTimeMillis());
        kafkaInstant.sendOrder(kafkaOrder);
        return "success";
    }

}
