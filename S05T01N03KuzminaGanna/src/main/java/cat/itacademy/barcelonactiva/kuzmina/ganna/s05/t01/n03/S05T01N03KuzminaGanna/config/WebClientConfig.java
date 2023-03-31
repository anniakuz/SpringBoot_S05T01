package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n03.S05T01N03KuzminaGanna.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    public static final String BASE_URL = "http://localhost:9001";

   // @Bean
    public WebClient webClient(){
        return WebClient.create(BASE_URL);
    }

}
