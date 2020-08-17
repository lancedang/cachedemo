package com.lance.cache.cachedemo.core.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lance.cache.cachedemo.common.dao.SwitchMappingRepository;
import com.lance.cache.cachedemo.common.utils.LanceJsonUtil;
import com.lance.cache.cachedemo.core.CacheInitializeInterface;
import com.lance.cache.cachedemo.core.CacheRefreshInterface;
import com.lance.cache.cachedemo.model.SwitchMappingEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

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
    @Scheduled(cron = "0/2 * * * * ?") //#每2秒执行一次，若refresh方法时长超过2s，则等refresh执行结束才执行下一次刷新
    public void refresh() throws InterruptedException {
        fullFillLocalMap();
        LOGGER.info("定时刷新日志开关: {}", JSON.toJSONString(logMap));
    }

    @Override
    @PostConstruct
    public void init() throws JsonProcessingException, InterruptedException {
        fullFillLocalMap();
        LOGGER.info("初始化日志开关: {}", JSON.toJSONString(logMap));
        LOGGER.info("初始化日志开关: {}", LanceJsonUtil.conMap2String(logMap));
    }

    private void fullFillLocalMap() throws InterruptedException {
        //Thread.sleep(5000);
        List<SwitchMappingEntity> allOpenSwitch = switchMappingRepository.findAllOpenSwitch();
        //初始化的时候插入DB中原始数据
        allOpenSwitch.stream().filter(item -> item.getName().equals("log")).forEach(item -> logMap.put(item.getName(), item));
    }
}
