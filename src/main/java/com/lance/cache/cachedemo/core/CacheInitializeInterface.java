package com.lance.cache.cachedemo.core;

/**
 * 为了避免硬编码，可以缓存一些外部静态数据（如配置在DB的中的城市信息,名称，编码）到内存，一般来讲，此类数据静态不变；
 * 对于较少数据也可以直接写到内存中，此接口统一封装初始化数据到内存的动作
 */
public interface CacheInitializeInterface {
    void init();
}
