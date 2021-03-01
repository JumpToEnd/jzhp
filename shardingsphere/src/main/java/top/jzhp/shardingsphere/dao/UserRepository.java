package top.jzhp.shardingsphere.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository  {

    int count();
}
