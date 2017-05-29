package ir.sbu.golestan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(exclude = RepositoryRestMvcAutoConfiguration.class)
@EnableJpaRepositories("ir.sbu.golestan.repository")
public class GolestanApplication {

	public static void main(String[] args) {
		SpringApplication.run(GolestanApplication.class, args);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
	}
}
