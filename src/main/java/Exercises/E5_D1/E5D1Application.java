package Exercises.E5_D1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class E5D1Application {

	public static void main(String[] args) {
		SpringApplication.run(E5D1Application.class, args);
		configurationClass();
	}

	public static void configurationClass() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(E5D1Application.class);
		ctx.getBean("menu");
	}

}

