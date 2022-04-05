package org.fudan.UMLConsistency.service.impl;

import org.fudan.UMLConsistency.service.StreamInputResolver;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-04 15:56
 * @description: 通过指定输入流来进行命令解析
 */
public class SimpleStreamInputResolver implements StreamInputResolver {

    private final Scanner scanner;

    public SimpleStreamInputResolver(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public String getNext() {
        return null;
    }
}
