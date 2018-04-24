package com.colin.webfluxdemo.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

/**
 * created with IntelliJ IDEA.
 * author: zhy
 * date: 2018/4/20 0020
 * time: 上午 10:58
 * description:
 */
@SuppressWarnings("unchecked")
public class SSEClient {
    public static void main(final String[] args) {
//        final WebClient client = WebClient.create();
//        client.get()
//                .uri("http://localhost:8080/sse/randomNumbers")
//                .accept(MediaType.TEXT_EVENT_STREAM)
//                .exchange()
//                .flatMapMany(response -> response.body(
//                        BodyExtractors.toFlux(
//                                new ParameterizedTypeReference() {
//                                }
//                        ))
//                )
//                .filter(sse -> Objects.nonNull(sse.data()))
//                .map(ServerSentEvent::data)
////                .map(data -> ServerSentEvent.builder().data(data))
//                .buffer(10)
//                .doOnNext(System.out::println)
//                .blockFirst();
    }
}