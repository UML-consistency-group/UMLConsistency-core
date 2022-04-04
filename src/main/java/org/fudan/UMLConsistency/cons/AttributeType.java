package org.fudan.UMLConsistency.cons;

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
    INT(e -> Integer.valueOf(e.toString()), "Integer"),
    /**
     * 字符串类型String
     */
    STRING(Object::toString, "String"),
    /**
     * 浮点类型float
     */
    FLOAT(e -> Float.parseFloat(e.toString()), "Float"),
    /**
     * 布尔类型
     */
    BOOLEAN(e -> Boolean.valueOf(e.toString()), "Boolean");

    private Function<Object, Object> parser;

    private String name;

    AttributeType(Function<Object, Object> parser, String name){
        this.name = name;
        this.parser = parser;
    }

    public String getName() {
        return name;
    }

    public Function<Object, Object> getParser(){
        return this.parser;
    }

    @Override
    public String toString() {
        return getName();
    }

    public static AttributeType typeOf(String s){
        for (AttributeType value : AttributeType.values()) {
            if(value.getName().equals(s)){
                return value;
            }
        }
        //TODO: 当该类型不支持时，抛出异常
        return null;
    }
}
