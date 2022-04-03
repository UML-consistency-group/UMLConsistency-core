package org.fudan.UMLConsistency.config;

import org.fudan.UMLConsistency.uml.UMLDefinitionReader;
import org.fudan.UMLConsistency.uml.impl.SimpleUMLDefinitionReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @author: zlyang
 * @date: 2022-04-03 14:26
 * @description:
 */
@Configuration
public class UMLConfig {

    @Bean
    UMLDefinitionReader getUMLDefinitionReader() throws IOException {
        return new SimpleUMLDefinitionReader(new ClassPathResource("test/test.yaml").getInputStream());
    }

}
