package com.cdtu.myComment;

import com.cdtu.myComment.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;

@SpringBootTest
class MyCommentApplicationTests {
@Resource
    UserDao userDao;
    @Test
    void contextLoads() {
        System.out.println(userDao.getByUsername("xueqiang"));
    }

}
