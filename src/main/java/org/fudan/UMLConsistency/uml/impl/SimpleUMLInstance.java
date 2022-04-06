package org.fudan.UMLConsistency.uml.impl;

import org.fudan.UMLConsistency.uml.UMLInstance;
import org.fudan.UMLConsistency.uml.UMLDefinition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: zlyang
 * @date: 2022-04-03 12:52
 * @description:
 */
public class SimpleUMLInstance implements UMLInstance {

    private final String name;

    private final UMLDefinition umlDefinition;

    private final Map<String, Object> attributes;

    private final Map<String, Set<UMLInstance>> references;

    public SimpleUMLInstance(String name, UMLDefinition umlDefinition){
        this.name = name;
        this.umlDefinition = umlDefinition;
        this.attributes = new HashMap<>(8);
        this.references = new HashMap<>(4);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDefinitionName() {
        return umlDefinition.getName();
    }

    @Override
    public UMLDefinition getDefinition() {
        return umlDefinition;
    }

    @Override
    public void removeReference(UMLInstance instanceToRemove) {
        Set<UMLInstance> umlInstances = references.get(instanceToRemove.getDefinitionName());
        umlInstances.remove(instanceToRemove);
    }


    @Override
    public Object get(String name) {
        return attributes.get(name);
    }

    @Override
    public UMLInstance set(String name, Object value) {
        if(!isValidAttribute(name)){
            //TODO: Throw error of invalid name
        }
        attributes.put(name, umlDefinition.getAttributeType(name).getParser().apply(value));
        return this;
    }

    @Override
    public Set<UMLInstance> getReferenceList(String name) {
        if(!isValidReference(name)){
            //TODO: Throw error of invalid name
        }
        return references.get(name);
    }

    @Override
    public int getReferenceCount(String name) {
        if(!isValidReference(name)){
            //TODO: Throw error of invalid name
        }
        return references.get(name).size();
    }

    @Override
    public UMLInstance setReference(UMLInstance ref) {
        String name = ref.getDefinitionName();
        if(!isValidReference(name)){
            //TODO: Throw error of invalid name
        }
        Set<UMLInstance> set = references.getOrDefault(name, new HashSet<>());
        set.add(ref);
        references.put(name, set);
        return this;
    }

    private boolean isValidAttribute(String name){
        return umlDefinition.isContainAttribute(name);
    }

    private boolean isValidReference(String name){
        return umlDefinition.isContainReference(name);
    }

    @Override
    public String toString() {
        return "SimpleUMLInstance{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes +
                ", references=" + references.keySet() +
                '}';
    }
}
