package top.jzhp.shardingsphere;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jzhp.shardingsphere.dao.UserRepository;

@SpringBootTest
class ShardingsphereApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {

        System.out.println(userRepository.count());
    }

}
