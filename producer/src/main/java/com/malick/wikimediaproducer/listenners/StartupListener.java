package com.malick.wikimediaproducer.listenners;

import com.malick.wikimediaproducer.stream.ApiStreaming;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

    private final ApiStreaming apiStreaming;

    @Autowired
    public StartupListener(ApiStreaming apiStreaming) {
        this.apiStreaming = apiStreaming;
    }
    @Override
    public void onApplicationEvent(@NonNull ContextRefreshedEvent event) {
        this.apiStreaming.publishData();
    }
}
