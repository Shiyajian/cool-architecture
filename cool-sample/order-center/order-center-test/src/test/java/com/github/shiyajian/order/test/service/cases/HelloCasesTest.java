package com.github.shiyajian.order.test.service.cases;

import com.github.shiyajian.cool.support.services.cases.CaseManager;
import com.github.shiyajian.order.service.cases.hello.create.HelloCreateCase;
import com.github.shiyajian.order.service.cases.hello.create.HelloCreateContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author shiyajian
 * create: 2023-06-20
 */
@SpringBootTest
public class HelloCasesTest {

    @Test
    public void testCreate() {
        HelloCreateContext helloCreateContext = new HelloCreateContext();
        HelloCreateContext result = CaseManager.execute(HelloCreateCase.class, helloCreateContext);
    }
}
