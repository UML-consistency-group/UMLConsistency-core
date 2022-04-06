package org.fudan.UMLConsistency.service.impl;

import org.fudan.UMLConsistency.service.StreamInputResolver;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-04 15:56
 * @description: 通过指定输入流来进行命令解析，使用Config bean构造，不要标注类
 */
public class SimpleStreamInputResolver implements StreamInputResolver {

    private final Scanner scanner;

    public SimpleStreamInputResolver(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public String getNext() {
        String next = null;
        while(scanner.hasNextLine() && !(next = scanner.nextLine().stripLeading()).startsWith("!")) {
            ;
        }
        return next;
    }
}
