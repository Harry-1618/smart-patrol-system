package com.hrt.smartpatrolsystem;

import com.hrt.smartpatrolsystem.service.impl.UserService;
import com.hrt.smartpatrolsystem.user.pojos.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SmartPatrolSystemApplication.class)
class SmartPatrolSystemApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        User user = userService.getById(1);
        System.out.println(user);
    }

}
