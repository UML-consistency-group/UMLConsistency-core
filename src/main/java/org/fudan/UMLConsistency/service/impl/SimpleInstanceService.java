package org.fudan.UMLConsistency.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.fudan.UMLConsistency.DAO.InstanceStorage;
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
@Slf4j
public class SimpleInstanceService implements InstanceService {

    private final Map<OptType, OptHandler> handlerMap = new HashMap<>();

    @Autowired
    private StreamInputResolver streamInputResolver;

    @Autowired
    private InstanceStorage instanceStorage;

    @Override
    public void runService() {
        String s;
        while((s = streamInputResolver.getNext()) != null){
            OptType optType = getOptType(s);
            handlerMap.get(optType).handleOpt(s);
            log.trace(instanceStorage.toString());
        }
    }

    @Override
    public void putOptHandler(OptType type, OptHandler handler) {
        handlerMap.put(type, handler);
    }

    private OptType getOptType(String s){
        return OptType.getType(s.stripLeading().substring(1, s.indexOf(' ')));
    }
}
