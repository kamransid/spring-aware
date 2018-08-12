package com.spring.develper.springaware;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.InjectionPoint
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/*
 * 
 * 
 * 2018-08-12 21:42:25.888  INFO 9784 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@35083305: startup date [Sun Aug 12 21:42:25 IST 2018]; root of context hierarchy
2018-08-12 21:42:26.280  INFO 9784 --- [           main] .SpringAwareApplication$LoggingComponent : Hello World
2018-08-12 21:42:26.381  INFO 9784 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
 * 
 * 
 * 
 * 
 * 
 * */

@SpringBootApplication
public class SpringAwareApplication {

	@Bean
	@Scope("prototype")
	Logger logger(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}

	@Component
	public static class LoggingComponent {

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
