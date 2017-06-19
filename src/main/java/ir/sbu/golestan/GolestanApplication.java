package ir.sbu.golestan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = RepositoryRestMvcAutoConfiguration.class)
public class GolestanApplication {

	public static void main(String[] args) {
		SpringApplication.run(GolestanApplication.class, args);
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
	}
}
