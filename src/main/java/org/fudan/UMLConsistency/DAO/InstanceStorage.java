package org.fudan.UMLConsistency.DAO;

import org.fudan.UMLConsistency.uml.UMLInstance;

import java.util.Set;

/**
 * @author: zlyang
 * @date: 2022-04-05 18:51
 * @description: UML对象实例的存储与查询接口
 */
public interface InstanceStorage {

    /**
     * 存储一个UML实例对象
     * @param instance 需要存储的对象
     */
    void addInstance(UMLInstance instance);

    /**
     * 为两个实例添加新的关系
     * @param nameA 实例A的名字
     * @param nameB 实例B的名字
     */
    void addAssociation(String nameA, String nameB);

    /**
     * 为实例更新属性
     * @param targetName 要更新实例对象的名字
     * @param newValue   需要更新的value
     */
    void setAttribute(String targetName, Object newValue);

    /**
     * 通过实例名删除实例
     * @param name 实例名
     */
    void deleteInstance(String name);

    /**
     * 通过实例名删除实例之间的关系
     * @param nameA 实例关系A
     * @param nameB 实例关系B
     */
    void deleteAssociation(String nameA, String nameB);

    /**
     * 通过对象名获取到该对象的实例
     * @param name 对象名
     * @return  对象实例
     */
    UMLInstance getInstanceByName(String name);

    /**
     * 通过类名获得属于该类的所有对象实例
     * @param className 类名
     * @return  所有对象实例
     */
    Set<UMLInstance> getAllInstanceByName(String className);

}
