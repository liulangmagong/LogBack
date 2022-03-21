package com.examples;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * @author wangshiyang
 * @since 2022/3/21
 **/
public class MyFilter extends Filter<ILoggingEvent> {
    private Level level;

    // logback会自动将level的值赋值给这个属性
    public void setLevel(Level level) {
        this.level = level;
    }

    public FilterReply decide(ILoggingEvent iLoggingEvent) {
        if (iLoggingEvent.getLevel().equals(this.level))
            return FilterReply.ACCEPT;
        return FilterReply.DENY;
    }
}
