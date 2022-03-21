package com.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangshiyang
 * @since 2022/3/20
 **/

/**
 * 日志的级别 TRACE < DEBUG < INFO < ERROR
 * 记录器是Logback中最重要的部分
 * 日志的记录器会将日志的输出任务交给日志的附加器来输出
 * 控制台附加器会将日志输出到控制台
 * 文件附加器会将日志输出到文件
 * 不同的附加器使用的时候使用的是不同的实现类
 */
public class App {
    // 得到日志记录器  这里的记录器是单例的
    // 获取的时候如果缓存中没有会自动创建，如果有就会直接获取
    // 这里日志记录器名称一般指定为包名+类名
    // 这里的名称不仅仅是一个名称，同时还表示当前记录器的等级
    // 在logback中，所有的记录器是按照树状结构进行组织，具有上下级的概念
    // 而这里上下级的关系就是通过这里的名称设定的
    // 记录器输出日志的级别可以在代码中配置也可以在xml文件中配置，子记录器没有设置的时候就会继承父记录器的设置
//    static Logger logger = LoggerFactory.getLogger("com.examples.App");
//    static Logger logger1 = LoggerFactory.getLogger("com.examples");  // logger的父记录器
//    static Logger logger2 = LoggerFactory.getLogger("com");  // logger的祖先记录器  它的父记录器是根记录器
    // 记录器之间继承关系，子记录器可以继承父记录器设置的属性
    // logbook记录器具有叠加性，可能会出现一次打印出现多个相同的日志信息
    static Logger logger = LoggerFactory.getLogger(App.class);  // 和上边是等价的
    public static void main(String[] args) {
        logger.info("Hello, world!");
//        while (true){
//            logger.info("Hello, world!");
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


    }
}
