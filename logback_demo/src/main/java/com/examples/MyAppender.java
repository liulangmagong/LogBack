package com.examples;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import ch.qos.logback.core.encoder.Encoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author wangshiyang
 * @since 2022/3/20
 * 模拟一个控制台附加器，将日志信息输出到控制台
 **/
public class MyAppender<E> extends UnsynchronizedAppenderBase<E> {
    // 继承UnsynchronizedAppenderBase类，并实现一下方法
    private Encoder encoder;  // 这里要和logback.xml里边的编码器encoder一致
    private String fileName;  // 文件附加器的内容

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    // 这里添加一个setter方法，这样的话，logback会自动给它赋值
    public void setEncoder(Encoder encoder) {
        this.encoder = encoder;
    }

    protected void append(E e) {
        // 使用编码器获取模版中涉及的所有数据
        ILoggingEvent event = (ILoggingEvent) e;  // e的数据类型
        byte[] byteArray = this.encoder.encode(e);
        // 转成字符串
        try {
            String s = new String(byteArray, "utf-8");
            // 文件附加器内容  利用文件名称生成一个file
            File file = new File(fileName);
            // 创建文件输出流  使用文件追加的方式
            FileOutputStream outputStream = new FileOutputStream(file, true);
            // 将日志内容输出到文件中
            outputStream.write(byteArray);
            // 在进行数据库操作或者IO操作的时候，必须确保资源在使用完毕后得到释放，并且确保释放操作在finally里进行
            outputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
