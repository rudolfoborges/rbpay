package rudolfoborges.rbpay.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author rudolfoborges
 * @since 3/21/17 4:05 PM
 */
@Profile("!default")
@Configuration
@EnableEurekaClient
public class EurekaClientConfiguration {
}
