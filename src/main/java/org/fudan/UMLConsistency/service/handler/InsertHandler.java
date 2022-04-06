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
 * @description: !insert (InstanceName1,InstanceName2) into assoc
 */
@Service
@OptHandlerType(value = OptType.INSERT)
public class InsertHandler implements OptHandler {
    @Autowired
    private InstanceStorage instanceStorage;

    @Autowired
    private UMLFactory umlFactory;

    @Override
    public UMLInstance handleOpt(String operation) {
        String [] attrs = operation.split("\\s+");
        String AssociationName = attrs[3];
        String instances = attrs[1];
        instances = instances.substring(1,instances.length()-1);
        String [] instanceList = instances.split(",");

        instanceStorage.addAssociation(instanceList[0],instanceList[1]);
        return null;
    }
}
