package com.lance.cache.cachedemo.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lance.cache.cachedemo.model.SwitchMappingEntity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LanceJsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String map2String(Map<String, Object> map) throws JsonProcessingException {
        return objectMapper.writeValueAsString(map);
    }

    public static String conMap2String(ConcurrentHashMap<String, SwitchMappingEntity> map) throws JsonProcessingException {
        return objectMapper.writeValueAsString(map);
    }

    public static String object2String(Object o) throws JsonProcessingException {
        return objectMapper.writeValueAsString(o);
    }
}
