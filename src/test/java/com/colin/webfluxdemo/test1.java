package com.colin.webfluxdemo;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * created with IntelliJ IDEA.
 * author: zhy
 * date: 2018/4/20 0020
 * time: 下午 14:23
 * description:
 */
public class test1 {
    public static void main(String[] args) throws InterruptedException {
//        Flux.range(1, 100).buffer(20).subscribe(System.out::println);
////        Flux.intervalMillis(100).bufferMillis(1001).take(2).toStream().forEach(System.out::println);
//        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
//        Flux.range(1, 10).bufferWhile(i -> (i % 2 == 0 || i % 3 == 0)).subscribe(System.out::println);
//        Flux.just("a", "b")
//                .zipWith(Flux.just("c", "d"))
//                .subscribe(System.out::println);
//        Flux.just("a", "b")
//                .zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
//                .subscribe(System.out::println);

        // take
//        Flux.range(1, 1000).take(10).subscribe(System.out::println);
//        Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
//        Flux.range(1, 1000).takeWhile(i -> i < 10).subscribe(System.out::println);
//        Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(System.out::println);

        // reduce
//        Flux.range(1, 100).reduce((x, y) -> x + y).subscribe(System.out::println);
//        Flux.range(1, 100).reduceWith(() -> 100, (x, y) -> x + y).subscribe(System.out::println);


//        Flux.merge(Flux.interval(Duration.ofMillis(50)).take(5),
//                Flux.interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(5))
//                .toStream()
//                .forEach(System.out::println);
//        Flux.mergeSequential(Flux.interval(Duration.ofMillis(50)).take(5), Flux.interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(5))
//                .toStream()
//                .forEach(System.out::println);

        // flatMap
//        Flux.just(5, 10)
//                .flatMapSequential(x -> Flux.interval(Duration.ofMillis(x * 10), Duration.ofMillis(100)).take(x))
//                .toStream()
//                .forEach(System.out::println);

        // concatMap
//        Flux.just(5, 10)
//                .concatMap(x -> Flux.interval(Duration.ofMillis(x * 10), Duration.ofMillis(100)).take(x))
//                .toStream()
//                .forEach(System.out::println);

//        Flux.combineLatest(
//                Arrays::toString,
//                Flux.interval(Duration.ofMillis(100)).take(5),
//                Flux.interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(5)
//        ).toStream().forEach(System.out::println);
//
//        Flux.just(1, 2)
//                .concatWith(Mono.error(new IllegalStateException()))
//                .subscribe(System.out::println, System.err::println);

//        Flux.just(1, 2)
//                .concatWith(Mono.error(new IllegalStateException()))
//                .onErrorReturn(0)
//                .subscribe(System.out::println);
//
//        Flux.just(1, 2)
//                .concatWith(Mono.error(new IllegalStateException()))
//                .retry(1)
//                .onErrorReturn(0)
//                .subscribe(System.out::println);
//
//        Flux.create(sink -> {
//            sink.next(Thread.currentThread().getName());
//            sink.complete();
//        })
//                .publishOn(Schedulers.single())
//                .log("Range")
//                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
//                .publishOn(Schedulers.elastic())
//                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
//                .subscribeOn(Schedulers.parallel())
//                .toStream()
//                .forEach(System.out::println);

        final Flux<Long> source = Flux.interval(Duration.ofMillis(1000))
                .take(10)
                .publish()
                .autoConnect();
        source.subscribe();
        Thread.sleep(5000);
        source
                .log("continue")
                .toStream()
                .forEach(System.out::println);
    }
}
