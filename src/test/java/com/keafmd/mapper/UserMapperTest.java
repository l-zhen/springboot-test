package com.keafmd.mapper;

import com.keafmd.SpringbootServerApplication;
import com.keafmd.entity.User;
import com.keafmd.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author lz
 * @Date 2022/2/22 13:56
 * @Version 1.0
 */
@SpringBootTest(classes = SpringbootServerApplication.class)
class UserMapperTest {

    @Resource
    UserService userService;
    @Test
    public void test1(){
        List<User> userList = userService.list();
        for (User user : userList){
            System.out.println(user);
        }
    }
}