package org.fudan.UMLConsistency.service.handler;

import org.fudan.UMLConsistency.DAO.InstanceStorage;
import org.fudan.UMLConsistency.service.OptHandler;
import org.fudan.UMLConsistency.service.OptHandlerType;
import org.fudan.UMLConsistency.cons.OptType;
import org.fudan.UMLConsistency.uml.UMLFactory;
import org.fudan.UMLConsistency.uml.UMLInstance;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zlyang
 * @date: 2022-04-04 15:41
 * @description: Set操作的具体实现
 */
/** !set InstanceName.AttributeName := value */
@Service
@OptHandlerType(value = OptType.SET)
public class SetHandler implements OptHandler {
    @Autowired
    private InstanceStorage instanceStorage;

    @Autowired
    private UMLFactory umlFactory;

    @Override
    public UMLInstance handleOpt(String operation) {
        String[] attrs=operation.split(" ");
        String value = attrs[3];
        String[] attrs2 = attrs[1].split(".");
        String instanceName = attrs2[0];
        String attributeName = attrs2[1];
        instanceStorage.setAttribute(instanceName,attributeName,value);


        return null;
    }
}
