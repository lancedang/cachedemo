package com.lance.cache.cachedemo.core.impl;

import com.lance.cache.cachedemo.common.dao.SwitchMappingRepository;
import com.lance.cache.cachedemo.core.CacheInitializeInterface;
import com.lance.cache.cachedemo.core.CacheRefreshInterface;
import com.lance.cache.cachedemo.model.SwitchMappingEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 日志开关缓存,初始化从DB读，然后定时刷新DB配置到内存
 */
@Service
public class LogSwitchCacheImpl implements CacheRefreshInterface, CacheInitializeInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogSwitchCacheImpl.class);

    private final ConcurrentHashMap<String, SwitchMappingEntity> logMap = new ConcurrentHashMap<>();

    @Autowired
    private SwitchMappingRepository switchMappingRepository;

    @Override
    public void refresh() {
        fullFillLocalMap();
        LOGGER.info("定时刷新日志开关: {}", logMap);
    }

    @Override
    @PostConstruct
    public void init() {
        fullFillLocalMap();
        LOGGER.info("初始化日志开关: {}", logMap);
    }

    private void fullFillLocalMap() {
        List<SwitchMappingEntity> allOpenSwitch = switchMappingRepository.findAllOpenSwitch();
        //初始化的时候插入DB中原始数据
        allOpenSwitch.stream().filter(item -> item.getName().equals("log")).forEach(item -> logMap.put(item.getName(), item));
    }
}
