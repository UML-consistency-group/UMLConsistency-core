package org.fudan.UMLConsistency.service.handler;

import org.fudan.UMLConsistency.DAO.InstanceStorage;
import org.fudan.UMLConsistency.cons.OptType;
import org.fudan.UMLConsistency.service.OptHandler;
import org.fudan.UMLConsistency.service.OptHandlerType;
import org.fudan.UMLConsistency.uml.UMLFactory;
import org.fudan.UMLConsistency.uml.UMLInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: jhchen
 * @date: 2022-04-06 21:10
 * @description: !destroy InstanceName
 */
@Service
@OptHandlerType(value = OptType.DESTROY)
public class DestroyHandler implements OptHandler {
    @Autowired
    private InstanceStorage instanceStorage;

    @Autowired
    private UMLFactory umlFactory;

    @Override
    public UMLInstance handleOpt(String operation) {
        String [] attrs = operation.split("\\s+");
        String instanceName = attrs[1];
        instanceStorage.deleteInstance(instanceName);
        return null;
    }
}
