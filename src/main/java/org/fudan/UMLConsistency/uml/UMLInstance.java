package org.fudan.UMLConsistency.uml;

import java.util.Set;

/**
 * @author: zlyang
 * @date: 2022-04-03 11:28
 * @description: UML类的具体实例接口，通过该接口获取该实例的相关信息
 */
public interface UMLInstance {

    /**
     * Get the name of this bean
     * @return name
     */
    String getName();

    /**
     * Get the UMLDefinition Name of current instance
     * @return UMLDefinition name
     */
    String getDefinitionName();

    /**
     * Get the UMLDefinition of current instance
     * @return UMLDefinition
     */
    UMLDefinition getDefinition();


    /**
     * 删除一个关系
     * @param instanceToRemove 需要删除的对象实例
     */
    void removeReference(UMLInstance instanceToRemove);


    /**
     * Get target value
     * @param name The name of target attribute
     * @return Using object for all attribute
     */
    Object get(String name);

    /**
     * Set value to target attribute
     * @param name  The attribute name
     * @param value The value to set
     * @return  Return self for chain set
     */
    UMLInstance set(String name, Object value);

    /**
     * Get current bean's relation UML beans
     * @param name The relation UML name
     * @return  The list of reference instances of target UML
     */
    Set<UMLInstance> getReferenceList(String name);

    /**
     * Get the num of current bean's relation to target UML beans
     * @param name The name of the target UML
     * @return The num of the ref
     */
    int getReferenceCount(String name);

    /**
     * Insert a new reference to an UML bean
     * @param name The name of target UML
     * @param ref  The ref of the bean
     * @return Return self for chain set
     */
    UMLInstance setReference(String name, UMLInstance ref);
}
