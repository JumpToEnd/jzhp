package top.jzhp.shardingsphere.dao;

import org.apache.ibatis.annotations.Mapper;
import top.jzhp.shardingsphere.entity.HealthRecord;

@Mapper
public interface HealthRecordRepository {

    int insert(HealthRecord healthRecord);
}
