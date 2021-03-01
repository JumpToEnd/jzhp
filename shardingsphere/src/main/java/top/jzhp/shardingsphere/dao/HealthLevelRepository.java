package top.jzhp.shardingsphere.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.jzhp.shardingsphere.entity.HealthLevel;

@Mapper
public interface HealthLevelRepository  {

    int insert(@Param("healthLevel") HealthLevel healthLevel);
}
