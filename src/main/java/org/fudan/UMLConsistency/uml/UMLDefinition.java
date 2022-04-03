package org.fudan.UMLConsistency.uml;

import org.fudan.UMLConsistency.uml.cons.AttributeType;
import org.fudan.UMLConsistency.uml.cons.RelationType;

import java.util.List;

/**
 * @author: zlyang
 * @date: 2022-04-03 10:44
 * @description:
 */
public interface UMLDefinition {

    /**
     * Get all attribute declared by the UML
     * @return The attribute name list of the UML
     */
    List<String> getAllAttribute();

    /**
     * Get all relation of this UML
     * @return The name of the reference/relation target UML;
     *         The void List(NOT NULL ref) when current UML has no relation.
     */
    List<String> getAllReference();

    /**
     * Get the type of the target attribute
     * @param name The name of target attribute
     * @return The type
     */
    AttributeType getAttributeType(String name);

    /**
     * Get the type of the target reference
     * @param name The name of target reference
     * @return The Relation type
     */
    RelationType getReferenceType(String name);

}
