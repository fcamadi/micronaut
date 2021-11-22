package org.francd.config;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("hello.translation")
public interface HelloWorldTranslationConfig {


    String getDe();

    String getEs();
}
