package org.fudan.UMLConsistency.uml;

/**
 * @author: zlyang
 * @date: 2022-04-03 10:38
 * @description: UML工厂，存储各个UML类图定义，通过类名返回相应的类实例
 */
public interface UMLFactory {

    /**
     * Refresh definition of UMLDefinitionMap from the reader.
     * Get all uml definition from reader
     */
    void refresh();

    /**
     * Find the definition of the target UML by name
     * @param name The name of target
     * @return The definition of the target UML
     */
    UMLDefinition getDefinitionByName(String name);

    /**
     * Create a new instance of a UMLBean
     * @param UMLName UML target name
     * @param instanceName instance name
     * @return The new instance
     */
    UMLInstance getNewInstance(String UMLName, String instanceName);

}
