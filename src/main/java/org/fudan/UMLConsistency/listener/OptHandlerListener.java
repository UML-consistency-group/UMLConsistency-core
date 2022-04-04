package org.fudan.UMLConsistency.listener;

import org.fudan.UMLConsistency.service.InstanceService;
import org.fudan.UMLConsistency.service.OptHandler;
import org.fudan.UMLConsistency.service.OptHandlerType;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Map;

/**
 * @author: zlyang
 * @date: 2022-04-04 16:07
 * @description: 通过Spring容器向InstanceService中注入实现的各个操作
 */
public class OptHandlerListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Map<String, Object> beans = event.getApplicationContext().getBeansWithAnnotation(OptHandlerType.class);
        InstanceService instanceService = event.getApplicationContext().getBean(InstanceService.class);
        beans.forEach((name, bean) -> {
            OptHandlerType annotationType = bean.getClass().getAnnotation(OptHandlerType.class);
            instanceService.putOptHandler(annotationType.value(), (OptHandler) bean);
        });
    }
}
