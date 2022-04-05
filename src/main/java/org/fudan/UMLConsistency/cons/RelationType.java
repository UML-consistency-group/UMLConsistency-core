package org.fudan.UMLConsistency.cons;

/**
 * @author: zlyang
 * @date: 2022-04-03 10:44
 * @description: The relationship type of the UML
 */
public enum RelationType {
    /**
     * 该类对应一个或多个类
     */
    MULTI("multiple"),
    /**
     * 该类对应且只对应一个类
     */
    SINGLE("single");

    public String getName() {
        return name;
    }

    RelationType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    private final String name;

    public static RelationType typeOf(String s){
        for (RelationType value : RelationType.values()) {
            if(value.getName().equals(s)){
                return value;
            }
        }
        //TODO: 不支持类型抛出异常
        return null;
    }
}
