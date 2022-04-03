package org.fudan.UMLConsistency.uml;

import java.util.Map;

/**
 * @author: zlyang
 * @date: 2022-04-03 10:42
 * @description:
 */
public interface UMLDefinitionReader {

    /**
     * Get all UML class defined in file
     * @return {className: {attributeName: attributeType}}
     */
    Map<String, Map<String, String>> getAllClass();

    /**
     * Get all UML relation defined in file
     * @return {relationName: {className: relationType}}
     */
    Map<String, Map<String, String>> getAllRelation();

}
