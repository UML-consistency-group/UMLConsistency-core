package org.fudan.UMLConsistency.config;

import org.fudan.UMLConsistency.uml.UMLDefinitionReader;
import org.fudan.UMLConsistency.uml.impl.SimpleUMLDefinitionReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zlyang
 * @date: 2022-04-03 14:26
 * @description:
 */
@Configuration
public class UMLConfig {

    @Bean
    UMLDefinitionReader getUMLDefinitionReader(){
        return new SimpleUMLDefinitionReader(System.in);
    }

}
