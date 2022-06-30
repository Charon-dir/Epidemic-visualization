package com.cdtu.myComment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;

@SpringBootTest
class MyCommentApplicationTests {
@Resource
HttpSession session;
    @Test
    void contextLoads() {
        System.out.println(session.getAttribute("name"));
    }

}
