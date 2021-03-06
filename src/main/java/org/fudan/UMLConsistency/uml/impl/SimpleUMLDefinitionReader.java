package org.fudan.UMLConsistency.uml.impl;

import org.fudan.UMLConsistency.uml.UMLDefinitionReader;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

/**
 * @author: zlyang
 * @date: 2022-04-03 14:07
 * @description:
 */
public class SimpleUMLDefinitionReader implements UMLDefinitionReader {


    private final Map<String, Map<String, Map<String, String>>> definitions;

    public SimpleUMLDefinitionReader(InputStream inputStream){
        definitions = new Yaml().load(inputStream);
    }


    @Override
    public Map<String, Map<String, String>> getAllClass() {
        return definitions.get("class");
    }

    @Override
    public Map<String, Map<String, String>> getAllRelation() {
        return definitions.get("association");
    }
}
