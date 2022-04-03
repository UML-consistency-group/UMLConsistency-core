package org.fudan.UMLConsistency;

import org.fudan.UMLConsistency.uml.UMLDefinitionReader;
import org.fudan.UMLConsistency.uml.UMLFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: zlyang
 * @date: 2022-04-03 17:13
 * @description:
 */
@SpringBootTest
public class UMLPackageTest {

    @Autowired
    UMLDefinitionReader umlDefinitionReader;

    @Autowired
    UMLFactory umlFactory;

    @Test
    public void testReadFile(){
        System.out.println(umlDefinitionReader.getAllClass());
        System.out.println(umlDefinitionReader.getAllRelation());
    }

    @Test
    public void testFactory(){
        System.out.println(umlFactory.getDefinitionByName("A"));
        System.out.println(umlFactory.getDefinitionByName("B"));
    }
}
