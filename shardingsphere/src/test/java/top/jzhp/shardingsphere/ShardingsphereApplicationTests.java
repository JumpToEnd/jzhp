package top.jzhp.shardingsphere;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jzhp.shardingsphere.dao.HealthLevelRepository;
import top.jzhp.shardingsphere.dao.UserRepository;
import top.jzhp.shardingsphere.entity.HealthLevel;
import top.jzhp.shardingsphere.entity.User;

@SpringBootTest
class ShardingsphereApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HealthLevelRepository healthLevelRepository;

    @Test
    void contextLoads() {


    }

    @Test
    void testHealthLevelInsert() {
        HealthLevel healthLevel = new HealthLevel(1L, "一级");
        System.out.println(healthLevelRepository.insert(healthLevel));
    }

    @Test
    void testUserInsert(){
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUserId((long) i);
            user.setUserName("user_" + i);
            userRepository.insert(user);
        }
    }

}
