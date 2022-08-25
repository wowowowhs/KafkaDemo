package com.whs.kafkademo.controller;

import com.google.gson.Gson;
import com.whs.kafkademo.entity.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    private static final String USER_INFO_TOPIC = "userInfo";

    @KafkaListener(topics = "test")
    public void listener(ConsumerRecord<?, ?> record) {
        System.out.println(String.format("topic:%s, offset:%d, value:%s ", record.topic(), record.offset(), record.value()));
    }

    @KafkaListener(topics = USER_INFO_TOPIC)
    public void listenerUserInfo(ConsumerRecord<?, ?> record) {
        Gson gson = new Gson();
        User user = gson.fromJson(record.value().toString(), User.class);
        System.out.println(String.format("user info, age=%d, name=%s", user.getAge(), user.getName()));
    }
}
