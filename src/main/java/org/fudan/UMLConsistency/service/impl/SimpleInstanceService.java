package org.fudan.UMLConsistency.service.impl;

import org.fudan.UMLConsistency.service.InstanceService;
import org.fudan.UMLConsistency.service.OptHandler;
import org.fudan.UMLConsistency.cons.OptType;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-04 16:12
 * @description:
 */
public class SimpleInstanceService implements InstanceService {

    private final Map<Integer, OptHandler> handlerMap = new HashMap<>();

    private final Scanner scanner;

    public SimpleInstanceService(InputStream inputStream){
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public void runService() {

    }

    @Override
    public void putOptHandler(OptType type, OptHandler handler) {
        handlerMap.put(type.getId(), handler);
    }
}
