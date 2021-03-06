package org.fudan.UMLConsistency.uml;

import java.util.Map;

/**
 * @author: zlyang
 * @date: 2022-04-03 10:42
 * @description: UML定义读取接口，UMLFactory通过该接口获取到UML图中所有类的定义
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
