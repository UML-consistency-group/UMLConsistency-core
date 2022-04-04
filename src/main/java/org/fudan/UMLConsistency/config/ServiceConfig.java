package org.fudan.UMLConsistency.config;

import org.fudan.UMLConsistency.service.InstanceService;
import org.fudan.UMLConsistency.service.impl.SimpleInstanceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @author: zlyang
 * @date: 2022-04-04 16:23
 * @description:
 */
@Configuration
public class ServiceConfig {

    @Bean
    InstanceService getInstanceService() throws IOException {
        return new SimpleInstanceService(new ClassPathResource("test/instance.txt").getInputStream());
    }

}
