package by.alex.certws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringAppLoader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpringAppLoader.class, args);
	}

}
