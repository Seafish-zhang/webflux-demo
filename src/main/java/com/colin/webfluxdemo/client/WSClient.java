package com.colin.webfluxdemo.client;

import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.time.Duration;

/**
 * created with IntelliJ IDEA.
 * author: zhy
 * date: 2018/4/20 0020
 * time: 上午 11:07
 * description:
 */
public class WSClient {
    public static void main(final String[] args) {
        final WebSocketClient client = new ReactorNettyWebSocketClient();
        client.execute(URI.create("ws://localhost:8080/echo"), session ->
                session.send(Flux.just(session.textMessage("Hello")))
                        .thenMany(session.receive().take(1).map(WebSocketMessage::getPayloadAsText))
                        .doOnNext(System.out::println)
                        .then())
                .block(Duration.ofMillis(5000));
    }
}
