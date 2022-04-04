package org.fudan.UMLConsistency.uml.impl;

import org.fudan.UMLConsistency.uml.UMLInstance;
import org.fudan.UMLConsistency.uml.UMLDefinition;
import org.fudan.UMLConsistency.uml.cons.AttributeType;
import org.fudan.UMLConsistency.uml.cons.RelationType;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: zlyang
 * @date: 2022-04-03 14:13
 * @description:
 */
public class SimpleUMLDefinition implements UMLDefinition {

    private final String name;

    private final Map<String, AttributeType> attributes;

    private final Map<UMLDefinition, RelationType> references;

    public SimpleUMLDefinition(String name){
        this.name = name;
        this.attributes = new HashMap<>(8);
        this.references = new HashMap<>(4);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UMLDefinition addAttribute(String name, AttributeType type) {
        attributes.put(name, type);
        return this;
    }

    @Override
    public UMLDefinition addReference(UMLDefinition target, RelationType type) {
        references.put(target, type);
        return this;
    }

    @Override
    public Set<String> getAllAttribute() {
        return attributes.keySet();
    }

    @Override
    public boolean isContainAttribute(String name) {
        return attributes.containsKey(name);
    }

    @Override
    public Set<UMLDefinition> getAllReference() {
        return references.keySet();
    }

    @Override
    public boolean isContainReference(String name) {
        return references.containsKey(name);
    }

    @Override
    public AttributeType getAttributeType(String name) {
        return attributes.get(name);
    }

    @Override
    public RelationType getReferenceType(String name) {
        return references.get(name);
    }

    @Override
    public UMLInstance getNewInstance(String name) {
        return new SimpleUMLInstance(name, this);
    }

    @Override
    public String toString() {
        return "SimpleUMLDefinition{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes +
                ", references=" + references.entrySet().stream().map(e -> e.getKey().getName() + ": " + e.getValue().toString()).collect(Collectors.toList()) +
                '}';
    }
}
