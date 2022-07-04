/**
 * Konfigurationsklasse um CorsMapping zu ermöglichen um Ressourcen
 * von Frontend auf Backend zusenden
 */

package htw.berlin.webtech.srandom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedMethods("*")
                .allowedOrigins(
                        "http://localhost:3000",
                        "https://srandom-app-frontend.herokuapp.com/"
                );
    }
}
