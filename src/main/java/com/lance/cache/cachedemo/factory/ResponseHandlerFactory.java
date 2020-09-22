package com.lance.cache.cachedemo.factory;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandlerFactory {
    private Map<String, ResponseHandlerInterface> handlerMap = new HashMap<>();

    public ResponseHandlerInterface getHandler(String channel) {
        return handlerMap.get(channel);
    }

    public void setHandlerMap(Map<String, ResponseHandlerInterface> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public Map<String, ResponseHandlerInterface> getHandlerMap() {
        return handlerMap;
    }
}
