package com.whs.kafkademo.controller;

import com.google.gson.Gson;
import com.whs.kafkademo.entity.User;
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
     * localhost:8012/kafka/send?msg=whs
     * @param msg
     */
    @GetMapping("/send")
    public void send(@RequestParam String msg) {
        kafkaTemplate.send("test", msg + msgNo++);
    }

    @GetMapping("/sendUser")
    public void sendUser(@RequestParam String name) {
        Gson gson = new Gson();
        User user = new User(1, name);
        kafkaTemplate.send("userInfo", gson.toJson(user));
    }
}
