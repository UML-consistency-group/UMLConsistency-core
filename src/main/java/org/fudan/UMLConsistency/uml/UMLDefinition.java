package org.fudan.UMLConsistency.uml;

import org.fudan.UMLConsistency.uml.cons.AttributeType;
import org.fudan.UMLConsistency.uml.cons.RelationType;

import java.util.Set;

/**
 * @author: zlyang
 * @date: 2022-04-03 10:44
 * @description: UML具体类定义接口，通过该接口获取类定义相关信息
 */
public interface UMLDefinition {

    /**
     * Get current name of this difinition
     * @return name
     */
    String getName();

    /**
     * Add new attribute to definition
     * @param name The name of new attribute
     * @param type The type of new attribute
     * @return self
     */
    UMLDefinition addAttribute(String name, AttributeType type);

    /**
     * Add new relation to definition
     * @param target The relation target
     * @param type   The relation type
     * @return self
     */
    UMLDefinition addReference(UMLDefinition target, RelationType type);

    /**
     * Get all attribute declared by the UML
     * @return The attribute name list of the UML
     */
    Set<String> getAllAttribute();

    /**
     * Judge if the attribute is contains in this definition
     * @param name The query name of the attribute
     * @return true if the name is in attribute list, false otherwise
     */
    boolean isContainAttribute(String name);

    /**
     * Get all relation of this UML
     * @return The name of the reference/relation target UML;
     *         The void List(NOT NULL ref) when current UML has no relation.
     */
    Set<UMLDefinition> getAllReference();

    /**
     * Judge if the reference is contains in this definition
     * @param name The query name of the reference
     * @return true if the name is in reference list, false otherwise
     */
    boolean isContainReference(String name);

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

    /**
     * Get a new instance of current uml
     * @param name Instance name
     * @return The new instance
     */
    UMLInstance getNewInstance(String name);

}
