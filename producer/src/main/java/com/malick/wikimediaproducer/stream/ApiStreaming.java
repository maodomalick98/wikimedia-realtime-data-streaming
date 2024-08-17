package com.malick.wikimediaproducer.stream;

import com.malick.wikimediaproducer.producers.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class ApiStreaming {

    private final WebClient webClient;
    private final Producer producer;

    public ApiStreaming(WebClient.Builder webClientBuilder,
                        Producer producer, @Value("${wikimedia-api.url}") String url) {
        this.webClient = webClientBuilder.
                baseUrl(url)
                .build();
        this.producer = producer;
    }

    public void publishData() {
        String endpoint = "/stream/recentchange";
        webClient.get()
                .uri(endpoint)
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(producer::sendMessage);
    }
}
