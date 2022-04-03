package org.fudan.UMLConsistency.uml.impl;

import org.fudan.UMLConsistency.uml.UMLDefinition;
import org.fudan.UMLConsistency.uml.UMLDefinitionReader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author: zlyang
 * @date: 2022-04-03 14:07
 * @description:
 */
public class SimpleUMLDefinitionReader implements UMLDefinitionReader {

    private final BufferedReader bufferedReader;

    public SimpleUMLDefinitionReader(InputStream inputStream){
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public SimpleUMLDefinitionReader(Reader reader){
        this.bufferedReader = new BufferedReader(reader);
    }

    @Override
    public UMLDefinition next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}
