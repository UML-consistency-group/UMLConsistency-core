package org.fudan.UMLConsistency.uml.impl;

import org.fudan.UMLConsistency.uml.UMLInstance;
import org.fudan.UMLConsistency.uml.UMLDefinition;
import org.fudan.UMLConsistency.cons.AttributeType;
import org.fudan.UMLConsistency.cons.RelationType;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: zlyang
 * @date: 2022-04-03 14:13
 * @description: UMLDefinition的实现类
 */
public class SimpleUMLDefinition implements UMLDefinition {

    private final String name;

    private final Map<String, AttributeType> attributes;

    private final Map<String, RefTarget> references;

    private class RefTarget{

        private final RelationType relationType;

        private final UMLDefinition umlDefinition;

        public RefTarget(RelationType relationType, UMLDefinition umlDefinition) {
            this.relationType = relationType;
            this.umlDefinition = umlDefinition;
        }
    }

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
        references.put(target.getName(), new RefTarget(type, target));
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
        return references.values().stream().map(e -> e.umlDefinition).collect(Collectors.toSet());
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
        return references.get(name).relationType;
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
                ", references=" + new ArrayList<>(references.keySet()) +
                '}';
    }
}
