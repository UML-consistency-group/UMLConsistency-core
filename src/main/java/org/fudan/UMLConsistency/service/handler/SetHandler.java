package org.fudan.UMLConsistency.service.handler;

import org.fudan.UMLConsistency.service.OptHandler;
import org.fudan.UMLConsistency.service.OptHandlerType;
import org.fudan.UMLConsistency.cons.OptType;
import org.fudan.UMLConsistency.uml.UMLInstance;
import org.springframework.stereotype.Service;

/**
 * @author: zlyang
 * @date: 2022-04-04 15:41
 * @description: Set操作的具体实现
 */
@Service
@OptHandlerType(value = OptType.SET)
public class SetHandler implements OptHandler {
    @Override
    public UMLInstance handleOpt(String operation) {
        return null;
    }
}
