package com.examples;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * @author wangshiyang
 * @since 2022/3/21
 **/
public class MyFilterByKeyword extends Filter<ILoggingEvent> {
    private String keyword;

    // logback会自动将level的值赋值给这个属性
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public FilterReply decide(ILoggingEvent iLoggingEvent) {
        if (iLoggingEvent.getMessage().contains(this.keyword))
            return FilterReply.ACCEPT;
        return FilterReply.DENY;
    }
}

