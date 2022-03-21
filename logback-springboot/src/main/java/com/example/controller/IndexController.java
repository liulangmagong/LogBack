package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * @author wangshiyang
 * @since 2022/3/21
 **/
@RestController
public class IndexController {

    // 创建一个记录器
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
//    private final Executor commonThreadPool;
//
//    public IndexController(Executor commonThreadPool) {
//        this.commonThreadPool = commonThreadPool;
//    }

    @GetMapping ("/index")
    public void index(){
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // 子任务
            try {
                TimeUnit.SECONDS.sleep(3);
                // 输出子线程名称
                logger.info(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return 123;
        }, threadPool);

        // supplyAsync() 可以进行结果返回  通过get() 获取子任务结果
        try {
            Integer value = future.get();
            // 主线程输出一条日志
            logger.info("hello springboot logback!" + "子线程输出的结果：" + value);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        // 关闭线程池
        threadPool.shutdown();

    }
}
