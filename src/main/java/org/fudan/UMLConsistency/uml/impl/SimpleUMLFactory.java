package org.fudan.UMLConsistency.uml.impl;

import org.fudan.UMLConsistency.uml.UMLBean;
import org.fudan.UMLConsistency.uml.UMLDefinition;
import org.fudan.UMLConsistency.uml.UMLDefinitionReader;
import org.fudan.UMLConsistency.uml.UMLFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zlyang
 * @date: 2022-04-03 14:22
 * @description:
 */
@Component
public class SimpleUMLFactory implements UMLFactory {

    @Autowired
    private UMLDefinitionReader umlDefinitionReader;

    private final Map<String, UMLDefinition> umlDefinitionMap = new HashMap<>();

    @Override
    public void refresh(UMLDefinitionReader umlDefinitionReader) {
        //TODO: 实现从文件流中读取uml图定义存储在umlDefinitionMap中
    }

    @Override
    public UMLDefinition getDefinitionByName(String name) {
        return umlDefinitionMap.get(name);
    }

    @Override
    public UMLBean getBeanNewInstance(String UMLName, String instanceName) {
        return umlDefinitionMap.get(UMLName).getNewInstance(instanceName);
    }
}
