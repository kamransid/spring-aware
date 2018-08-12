package com.spring.develper.springaware;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


@SpringBootApplication
public class SpringAwareApplication {

    @Bean
    @Scope("prototype")
    Logger logger(InjectionPoint injectionPoint) {
    	return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
    
    
    @Component
    public static class LoggingComponent{
    	
    	private final Logger logger;
    	
    	public LoggingComponent(Logger logger) {
    		this.logger = logger;
    		this.logger.info("Hello World");
    	}
    	
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAwareApplication.class, args);
	}
}


