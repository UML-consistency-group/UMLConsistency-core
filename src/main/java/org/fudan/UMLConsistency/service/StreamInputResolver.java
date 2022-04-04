package org.fudan.UMLConsistency.service;

import org.fudan.UMLConsistency.uml.UMLInstance;

/**
 * @author: zlyang
 * @date: 2022-04-04 15:20
 * @description: 从输入流中获取create或set命令，封装成相应对象
 */
public interface StreamInputResolver {

    /**
     * 获取下一条命令
     * @return 下一条命令行，当不再有命令时返回null
     */
    String getNext();

}
