package org.fudan.UMLConsistency.service.impl;

import org.fudan.UMLConsistency.service.InstanceService;
import org.fudan.UMLConsistency.service.OptHandler;
import org.fudan.UMLConsistency.cons.OptType;
import org.fudan.UMLConsistency.service.StreamInputResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zlyang
 * @date: 2022-04-04 16:12
 * @description:
 */
@Service
public class SimpleInstanceService implements InstanceService {

    private final Map<OptType, OptHandler> handlerMap = new HashMap<>();

    @Autowired
    private StreamInputResolver streamInputResolver;

    @Override
    public void runService() {

    }

    @Override
    public void putOptHandler(OptType type, OptHandler handler) {
        handlerMap.put(type, handler);
    }
}
