package org.fudan.UMLConsistency.service;

import org.fudan.UMLConsistency.cons.OptType;

import java.lang.annotation.*;

/**
 * @author: zlyang
 * @date: 2022-04-04 15:20
 * @description: 注解不同种类的操作
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OptHandlerType {

    OptType value();
}
