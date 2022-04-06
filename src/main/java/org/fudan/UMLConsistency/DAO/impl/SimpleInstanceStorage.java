package org.fudan.UMLConsistency.DAO.impl;

import org.fudan.UMLConsistency.DAO.InstanceStorage;
import org.fudan.UMLConsistency.uml.UMLInstance;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author:Chen Yang
 * @date: 2022-04-05 19:35
 * @description: The implementation of DAO
 */
@Repository
public class SimpleInstanceStorage implements InstanceStorage {

    private final Map<String,UMLInstance> instanceWarehouse;

    public SimpleInstanceStorage(){
        this.instanceWarehouse = new HashMap<String,UMLInstance>();
    }
    @Override
    public void addInstance(UMLInstance instance) {
        String name = instance.getName();
        instanceWarehouse.put(name,instance);
    }

    @Override
    public void addAssociation(String nameA, String nameB) {
        UMLInstance A = instanceWarehouse.get(nameA);
        UMLInstance B = instanceWarehouse.get(nameB);
        A.setReference(B);
        B.setReference(A);
        instanceWarehouse.put(nameA,A);
        instanceWarehouse.put(nameB,B);
    }

    @Override
    public void setAttribute(String targetName, String targetAttributeName, Object newValue) {
        UMLInstance target = instanceWarehouse.get(targetName);
        target.set(targetAttributeName,newValue);
    }

    @Override
    public void deleteInstance(String name) {
        instanceWarehouse.remove(name);
    }

    @Override
    public void deleteAssociation(String nameA, String nameB) {
        UMLInstance A = instanceWarehouse.get(nameA);
        UMLInstance B = instanceWarehouse.get(nameB);
        A.removeReference(B);
        B.removeReference(A);
        instanceWarehouse.put(nameA,A);
        instanceWarehouse.put(nameB,B);
    }

    @Override
    public UMLInstance getInstanceByName(String name) {
        return instanceWarehouse.get(name);
    }

    @Override
    public Set<UMLInstance> getAllInstanceByName(String className) {
        Set<UMLInstance>  result = new HashSet<UMLInstance>();
        for(UMLInstance value:instanceWarehouse.values()){
            if(value.getDefinition().getName().equals(className)){
                result.add(value);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "SimpleInstanceStorage{" +
                "instanceWarehouse=" + instanceWarehouse +
                '}';
    }
}
