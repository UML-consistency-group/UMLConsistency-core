package org.fudan.UMLConsistency.uml.cons;

/**
 * @author: zlyang
 * @date: 2022-04-03 10:44
 * @description: The relationship type of the UML
 */
public enum RelationType {
    /**
     * 一对多
     */
    SingleToMulti,
    /**
     * 一对一
     */
    SingleToSingle,
    /**
     * 多对一
     */
    MultiToSingle;
}
