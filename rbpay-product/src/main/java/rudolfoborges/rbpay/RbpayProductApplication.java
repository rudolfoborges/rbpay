package rudolfoborges.rbpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RBPayProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(RBPayProductApplication.class, args);
	}
}
