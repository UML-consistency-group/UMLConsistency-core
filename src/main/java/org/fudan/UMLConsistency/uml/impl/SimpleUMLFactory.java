package org.fudan.UMLConsistency.uml.impl;

import org.fudan.UMLConsistency.uml.UMLInstance;
import org.fudan.UMLConsistency.uml.UMLDefinition;
import org.fudan.UMLConsistency.uml.UMLDefinitionReader;
import org.fudan.UMLConsistency.uml.UMLFactory;
import org.fudan.UMLConsistency.uml.cons.AttributeType;
import org.fudan.UMLConsistency.uml.cons.RelationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zlyang
 * @date: 2022-04-03 14:22
 * @description:
 */
@Component
public class SimpleUMLFactory implements UMLFactory, ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UMLDefinitionReader umlDefinitionReader;

    private final Map<String, UMLDefinition> umlDefinitionMap = new HashMap<>();

    @Override
    public void refresh() {
        for (Map.Entry<String, Map<String, String>> newClass : umlDefinitionReader.getAllClass().entrySet()) {
            SimpleUMLDefinition definition = new SimpleUMLDefinition(newClass.getKey());
            for (Map.Entry<String, String> attribute : newClass.getValue().entrySet()) {
                definition.addAttribute(attribute.getKey(), AttributeType.typeOf(attribute.getValue()));
            }
            umlDefinitionMap.put(newClass.getKey(), definition);
        }
        for (Map.Entry<String, Map<String, String>> relation : umlDefinitionReader.getAllRelation().entrySet()) {
            String[] keys = new String[2];
            int i = 0;
            for (String key : relation.getValue().keySet()) {
                keys[i++] = key;
            }
            setReference(keys[0], keys[1], relation.getValue());
        }
    }

    @Override
    public UMLDefinition getDefinitionByName(String name) {
        return umlDefinitionMap.get(name);
    }

    @Override
    public UMLInstance getNewInstance(String UMLName, String instanceName) {
        return umlDefinitionMap.get(UMLName).getNewInstance(instanceName);
    }

    private void setReference(String a, String b, Map<String, String> relation){
        setReference(umlDefinitionMap.get(a),
                    umlDefinitionMap.get(b),
                    RelationType.typeOf(relation.get(a)),
                    RelationType.typeOf(relation.get(b)));
    }

    private void setReference(UMLDefinition a, UMLDefinition b, RelationType aType, RelationType bType){
        a.addReference(b, aType);
        b.addReference(a, bType);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        refresh();
    }
}
