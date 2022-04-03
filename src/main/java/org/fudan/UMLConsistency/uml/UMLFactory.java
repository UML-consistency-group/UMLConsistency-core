package org.fudan.UMLConsistency.uml;

/**
 * @author: zlyang
 * @date: 2022-04-03 10:38
 * @description:
 */
public interface UMLFactory {

    /**
     * Refresh definition of UMLDefinitionMap from the reader
     * @param umlDefinitionReader The definition reader needed
     */
    void refresh(UMLDefinitionReader umlDefinitionReader);

    /**
     * Find the definition of the target UML by name
     * @param name The name of target
     * @return The definition of the target UML
     */
    UMLDefinition getDefinitionByName(String name);

}
