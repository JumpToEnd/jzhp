package top.jzhp.shardingsphere.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.jzhp.shardingsphere.entity.HealthTask;

@Mapper
public interface HealthTaskRepository  {


    int insert(HealthTask healthTask);
}
