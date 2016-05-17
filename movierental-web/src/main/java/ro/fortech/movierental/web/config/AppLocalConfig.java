package ro.fortech.movierental.web.config;

/**
 * Created by Adi on 16.05.2016.
 */

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ro.fortech.movierental.core.JpaConfig;

/**
 * Local configuration activated by the local Spring profile.
 */

@Configuration
@ComponentScan("ro.fortech.movierental.core")
@Import({JpaConfig.class})
@PropertySources({@PropertySource(value = "classpath:local/db.properties"),
})
public class AppLocalConfig {

    /**
     * Enables placeholders usage with SpEL expressions.
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
