package com.colin.webfluxdemo.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

/**
 * created with IntelliJ IDEA.
 * author: zhy
 * date: 2018/4/20 0020
 * time: 上午 10:36
 * description:
 */
@Component
public class EchoHandler implements WebSocketHandler {
    @Override
    public Mono handle(final WebSocketSession session) {
        return session.send(
                session.receive()
                        .map(msg -> session.textMessage("ECHO -> " + msg.getPayloadAsText())));
    }
}
