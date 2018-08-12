package com.spring.develper.springaware;

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
 * Invocation of init method failed;
 * nested exception is java.lang.IllegalArgumentException:
 *Bar can't be null
 * 
 * 
 * 
 * */
@SpringBootApplication
public class SpringAwareApplication {

	@Bean
	Foo foo() {
		return new Foo();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAwareApplication.class, args);
	}
}

class Foo implements InitializingBean {

	private Bar bar;

	public Foo() {

	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		Assert.notNull(this.bar, "Bar can't be null");
	}

}

class Bar {

}
