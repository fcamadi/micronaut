package org.francd;

import io.micronaut.inject.BeanDefinition;
import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        var appContext = Micronaut.run(Application.class, args);

        var beans = appContext.getAllBeanDefinitions();
        for (BeanDefinition bd : beans) {
            System.out.println("bean: "+bd.getName());
        }
    }
}
