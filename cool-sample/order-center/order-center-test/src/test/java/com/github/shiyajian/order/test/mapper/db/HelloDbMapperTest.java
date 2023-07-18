package com.github.shiyajian.order.test.mapper.db;

import com.github.shiyajian.order.infrastructure.mapper.db.HelloDbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author shiyajian
 * create: 2023-06-20
 */
@SpringBootTest
public class HelloDbMapperTest {

    @Autowired
    private HelloDbMapper helloDbMapper;
}
