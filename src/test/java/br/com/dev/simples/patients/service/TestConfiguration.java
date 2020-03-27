package br.com.dev.simples.patients.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration()
@ComponentScan(basePackages = {"br.com.dev.simples.patients"})
@PropertySource("classpath:application-local.properties")
public class TestConfiguration {

}
