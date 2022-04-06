package org.fudan.UMLConsistency.service.handler;

import org.fudan.UMLConsistency.DAO.InstanceStorage;
import org.fudan.UMLConsistency.service.OptHandler;
import org.fudan.UMLConsistency.service.OptHandlerType;
import org.fudan.UMLConsistency.cons.OptType;
import org.fudan.UMLConsistency.uml.UMLFactory;
import org.fudan.UMLConsistency.uml.UMLInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zlyang
 * @date: 2022-04-04 15:40
 * @description: 处理create操作的对象
 */

/**!create UMLGraphName : InstanceName*/
@Service
@OptHandlerType(value = OptType.CREATE)
public class CreateHandler implements OptHandler {

    @Autowired
    private InstanceStorage instanceStorage;

    @Autowired
     private UMLFactory umlFactory;

    @Override
    public UMLInstance handleOpt(String operation) {
        /** 分解参数 */
        String[] attrs=operation.split(" ");
        String umlName = attrs[1];
        String instanceName = attrs[3];
        UMLInstance instance = umlFactory.getNewInstance(umlName,instanceName);
        instanceStorage.addInstance(instance);
        return instance;
    }
}
