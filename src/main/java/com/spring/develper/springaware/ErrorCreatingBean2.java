package com.spring.develper.springaware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

/*
 * 
 * org.springframework.beans.factory.BeanCreationException:
 * Error creating bean with name 'foo' defined in
 * com.spring.develper.springaware.SpringAwareApplication:
 * Bean instantiation via factory method failed;
 * nested exception is org.springframework.beans.BeanInstantiationException:
 * Failed to instantiate [com.spring.develper.springaware.Foo]:
 * Factory method 'foo' threw exception; nested exception is
 * java.lang.IllegalArgumentException: Bar Nere be null i told you already ....
 * 
 * 
 * 
 * */
@SpringBootApplication
public class SpringAwareApplication {

	@Bean
	Foo foo() {
		Foo foo = new Foo();
		foo.anyThing();
		return foo;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAwareApplication.class, args);
	}
}

class Foo {

	private Bar bar;

	public Foo() {

	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	@PostConstruct
	public void anyThing() {
		Assert.notNull(this.bar, "Bar Nere be null i told you already ....");
	}

	@PreDestroy
	public void anyThingAgain() {
		this.bar = null;
	}

}

class Bar {

}
