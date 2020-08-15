package com.lance.cache.cachedemo.common.mapper;

import com.lance.cache.cachedemo.model.SwitchMappingEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SwitchMappingMapper {
    List<SwitchMappingEntity> findAllOpenSwitch();
}
