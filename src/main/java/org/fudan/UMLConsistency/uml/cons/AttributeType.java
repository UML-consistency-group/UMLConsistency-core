package org.fudan.UMLConsistency.uml.cons;

import java.util.function.Function;

/**
 * @author: zlyang
 * @date: 2022-04-03 10:44
 * @description: The type of the attribute in UML
 */
public enum AttributeType {

    /**
     * 整型类型int
     */
    INT(e -> Integer.valueOf(e.toString())),
    /**
     * 字符串类型String
     */
    STRING(Object::toString),
    /**
     * 浮点类型float
     */
    FLOAT(e -> Float.parseFloat(e.toString())),
    /**
     * 布尔类型
     */
    BOOLEAN(e -> Boolean.valueOf(e.toString()));

    private Function<Object, Object> parser;

    AttributeType(Function<Object, Object> parser){
        this.parser = parser;
    }

    public Function<Object, Object> getParser(){
        return this.parser;
    }
}
