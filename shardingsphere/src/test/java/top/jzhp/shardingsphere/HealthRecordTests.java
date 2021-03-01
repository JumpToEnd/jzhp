package top.jzhp.shardingsphere;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jzhp.shardingsphere.dao.HealthRecordRepository;
import top.jzhp.shardingsphere.dao.HealthTaskRepository;
import top.jzhp.shardingsphere.entity.HealthRecord;
import top.jzhp.shardingsphere.entity.HealthTask;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class HealthRecordTests {

    @Autowired
    private HealthRecordRepository healthRecordRepository;

    @Autowired
    private HealthTaskRepository healthTaskRepository;

    @Test
    void testHealthRecordsInsert() throws SQLException {

        insertHealthRecords();
    }

    private List<Long> insertHealthRecords() throws SQLException {
        List<Long> result = new ArrayList<>(10);
        for (Long i = 1L; i <= 10; i++) {
            HealthRecord healthRecord = insertHealthRecord(i);
            insertHealthTask(i, healthRecord);
            result.add(healthRecord.getRecordId());
        }
        return result;
    }

    private HealthRecord insertHealthRecord(final Long i) throws SQLException {
        HealthRecord healthRecord = new HealthRecord();
        healthRecord.setUserId(i);
        healthRecord.setLevelId(i % 5);
        healthRecord.setRemark("Remark" + i);
        healthRecordRepository.insert(healthRecord);
        return healthRecord;
    }

    private void insertHealthTask(final Long i, final HealthRecord healthRecord) throws SQLException {
        HealthTask healthTask = new HealthTask();
        healthTask.setRecordId(healthRecord.getRecordId());
        healthTask.setUserId(i);
        healthTask.setTaskName("TaskName" + i);
        healthTaskRepository.insert(healthTask);
    }
}
