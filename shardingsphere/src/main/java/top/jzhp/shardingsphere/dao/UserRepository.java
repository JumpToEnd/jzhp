package top.jzhp.shardingsphere.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.jzhp.shardingsphere.entity.User;

@Mapper
public interface UserRepository {


    int insert(@Param("user") User user);
}
