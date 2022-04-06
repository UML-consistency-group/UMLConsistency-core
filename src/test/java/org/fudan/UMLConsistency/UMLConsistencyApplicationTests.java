package org.fudan.UMLConsistency;

import org.fudan.UMLConsistency.service.InstanceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: zlyang
 * @date: 2022-04-03 10:16
 * @description:
 */
@SpringBootTest
public class UMLConsistencyApplicationTests {

    @Autowired
    private InstanceService instanceService;

    @Test
    public void testService(){
        instanceService.runService();

    }
}
