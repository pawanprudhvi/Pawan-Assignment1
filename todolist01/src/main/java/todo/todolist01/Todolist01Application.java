package todo.todolist01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude = { R2dbcAutoConfiguration.class })
public class Todolist01Application {

	public static void main(String[] args) {
		SpringApplication.run(Todolist01Application.class, args);
	}

}
