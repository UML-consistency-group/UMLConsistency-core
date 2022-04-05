package org.fudan.UMLConsistency.DAO.impl;

import org.fudan.UMLConsistency.DAO.InstanceStorage;
import org.fudan.UMLConsistency.uml.UMLInstance;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author:
 * @date: 2022-04-05 19:35
 * @description:
 */
@Repository
public class SimpleInstanceStorage implements InstanceStorage {

    @Override
    public void addInstance(UMLInstance instance) {

    }

    @Override
    public void addAssociation(String nameA, String nameB) {

    }

    @Override
    public void setAttribute(String targetName, Object newValue) {

    }

    @Override
    public void deleteInstance(String name) {

    }

    @Override
    public void deleteAssociation(String nameA, String nameB) {

    }

    @Override
    public UMLInstance getInstanceByName(String name) {
        return null;
    }

    @Override
    public Set<UMLInstance> getAllInstanceByName(String className) {
        return null;
    }
}
