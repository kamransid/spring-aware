package com.spring.develper.springaware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;


@SpringBootApplication
public class SpringAwareApplication {

	
	public interface Foo{
		
	}
	
	public static class Foo2 implements Foo{
		
	}
	
	public static class Foo1 implements Foo{
		
	}
	
	
	@Bean
	FooFactoryBean fooFactoryBean() {
		return new FooFactoryBean();
	}
	
	public static class FooFactoryBean implements FactoryBean<Foo>{

		private boolean preferOne=true;
		
		public boolean isPreferOne() {
			return preferOne;
		}

		public void setPreferOne(boolean preferOne) {
			this.preferOne = preferOne;
		}

		@Override
		public Foo getObject() throws Exception {
			// TODO Auto-generated method stub
			return preferOne ? new Foo1() : new Foo2();
		}

		@Override
		public Class<?> getObjectType() {
			// TODO Auto-generated method stub
			return Foo.class;
		}
		
	}
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringAwareApplication.class, args);
	}
}


