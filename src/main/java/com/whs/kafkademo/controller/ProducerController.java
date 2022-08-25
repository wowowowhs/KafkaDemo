package com.whs.kafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class ProducerController {
    int msgNo = 0;

    /**
     * 注入kafka模板
     */
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 发送消息
     * @param msg
     */
    @GetMapping("/send")
    public void send(@RequestParam String msg) {
        kafkaTemplate.send("test", msg + msgNo++);
    }
}
