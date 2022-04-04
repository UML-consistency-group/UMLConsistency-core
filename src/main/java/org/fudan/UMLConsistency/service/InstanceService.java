package org.fudan.UMLConsistency.service;

import org.fudan.UMLConsistency.cons.OptType;

/**
 * @author: zlyang
 * @date: 2022-04-04 16:02
 * @description: 服务运行相关接口
 */
public interface InstanceService {

    /**
     * 启动服务运行
     */
    void runService();

    /**
     * 通过Spring容器托管实现策略模式处理不同类型的命令
     * @param type 操作类型
     * @param handler 操作函数
     */
    void putOptHandler(OptType type, OptHandler handler);
}
