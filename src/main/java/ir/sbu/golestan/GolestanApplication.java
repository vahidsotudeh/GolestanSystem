package ir.sbu.golestan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;


@SpringBootApplication(exclude = RepositoryRestMvcAutoConfiguration.class)
public class GolestanApplication {

	public static void main(String[] args) {
		SpringApplication.run(GolestanApplication.class, args);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
	}
}
