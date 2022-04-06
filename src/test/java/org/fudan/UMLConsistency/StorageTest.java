package org.fudan.UMLConsistency;

import org.fudan.UMLConsistency.DAO.InstanceStorage;
import org.fudan.UMLConsistency.service.OptHandler;
import org.fudan.UMLConsistency.service.StreamInputResolver;
import org.fudan.UMLConsistency.uml.UMLInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

/**
 * @author: Yang Chen
 * @date: 2022-04-06 21:28
 * @description: Test for DAO
 */
@SpringBootTest
public class StorageTest {

    @Autowired
    InstanceStorage instanceStorage;

    @Autowired
    StreamInputResolver streamInputResolver;

    @Autowired
    OptHandler createHandler;

    @Test
    public void testInsert(){
        String s;
        while((s = streamInputResolver.getNext()) != null){
            UMLInstance umlInstance = createHandler.handleOpt(s);
            instanceStorage.addInstance(umlInstance);
            System.out.println(umlInstance);
        }
        instanceStorage.setAttribute("car1","registrationNumber","123123");
        instanceStorage.addAssociation("car1","rental1");
        UMLInstance A = instanceStorage.getInstanceByName("car1");
        Set<UMLInstance> carSet = instanceStorage.getAllInstanceByName("Car");
        instanceStorage.deleteAssociation("car1","rental1");
        instanceStorage.deleteInstance("car1");

    }

}
