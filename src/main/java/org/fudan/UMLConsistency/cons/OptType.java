package org.fudan.UMLConsistency.cons;

/**
 * @author: zlyang
 * @date: 2022-04-04 15:20
 * @description: 操作类型的枚举类
 */
public enum OptType {

    /**
     * 对应创建操作:
     * !create UMLGraphName : InstanceName
     */
    CREATE(1, "create"),
    /**
     * 对应设置属性操作:
     * !set InstanceName.AttributeName := value
     */
    SET(2, "set"),

    /**
     * 销毁实例对象
     * !destroy InstanceName
     */
    DESTROY(3,"destroy"),

    /**
     * 建立关系
     * !insert (InstanceName1,InstanceName2) into assoc
     */
    INSERT(4,"insert"),

    /**
     * 销毁关系
     * !delete (InstanceName1,InstanceName2) from assoc
     */
    DELETE(5,"delete");

    /**
     *
     */


    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    OptType(int id, String type) {
        this.type = type;
        this.id = id;
    }

    public static OptType getType(int id){
        for (OptType value : OptType.values()) {
            if(value.getId() == id){
                return value;
            }
        }
        return null;
    }

    public static OptType getType(String name){
        for (OptType value : OptType.values()) {
            if(value.getType().equals(name)){
                return value;
            }
        }
        return null;
    }

    private final String type;

    private final int id;
}
