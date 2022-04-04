package org.fudan.UMLConsistency.service.handler;

import org.fudan.UMLConsistency.service.OptHandler;
import org.fudan.UMLConsistency.service.OptHandlerType;
import org.fudan.UMLConsistency.cons.OptType;
import org.fudan.UMLConsistency.uml.UMLInstance;
import org.springframework.stereotype.Service;

/**
 * @author: zlyang
 * @date: 2022-04-04 15:40
 * @description: 处理create操作的对象
 */
@Service
@OptHandlerType(value = OptType.CREATE)
public class CreateHandler implements OptHandler {
    @Override
    public UMLInstance handleOpt(String operation) {
        return null;
    }
}
