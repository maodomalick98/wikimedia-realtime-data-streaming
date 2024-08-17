package com.maodo.wikimediaconsumer.consumers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {
    @KafkaListener(topics = "wikimedia-topic", groupId = "recentChangesGroup")
    public void consumeMessage(String message) {
        log.info(String.format("Wikimedia stream: %s", message));
    }

}
