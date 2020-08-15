package com.lance.cache.cachedemo.common.dao;

import com.lance.cache.cachedemo.common.mapper.SwitchMappingMapper;
import com.lance.cache.cachedemo.model.SwitchMappingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SwitchMappingRepository {
    @Autowired
    private SwitchMappingMapper switchMappingMapper;

    public List<SwitchMappingEntity> findAllOpenSwitch() {
        return switchMappingMapper.findAllOpenSwitch();
    }

}
