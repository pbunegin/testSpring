package com.spring.test.loggers;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache = new ArrayList<>();

    public CacheFileEventLogger(int cacheSize, String fileName) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() > cacheSize) {
            cache.forEach(super::logEvent);
            cache.clear();
        }
    }

    private void destroy(){
        if (!cache.isEmpty()){
            cache.forEach(super::logEvent);
        }
    }
}
