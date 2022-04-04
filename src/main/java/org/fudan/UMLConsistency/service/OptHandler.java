package org.fudan.UMLConsistency.service;

import org.fudan.UMLConsistency.uml.UMLInstance;

/**
 * @author: zlyang
 * @date: 2022-04-04 15:36
 * @description: 操作处理接口，不同实现类实现create, set等不同类型的对应操作
 */
public interface OptHandler {

    /**
     * 具体处理相应操作的接口
     * @param operation 输入的操作的字符串
     * @return 根据相应操作获取的对象
     */
    UMLInstance handleOpt(String operation);
}
