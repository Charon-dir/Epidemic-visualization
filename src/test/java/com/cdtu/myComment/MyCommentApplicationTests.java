package com.cdtu.myComment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class MyCommentApplicationTests {

    @Test
    void contextLoads() {
        File folder = new File("d:\\test1\\test2");
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
        }
    }

}
