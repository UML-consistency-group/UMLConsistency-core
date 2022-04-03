package org.fudan.UMLConsistency.uml;

/**
 * @author: zlyang
 * @date: 2022-04-03 10:42
 * @description:
 */
public interface UMLDefinitionReader {

    /**
     * Get next definition
     * @return next UML definition
     */
    UMLDefinition next();

    /**
     * To Judge if has more definition to read
     * @return true if more is valid, false otherwise
     */
    boolean hasNext();
}
