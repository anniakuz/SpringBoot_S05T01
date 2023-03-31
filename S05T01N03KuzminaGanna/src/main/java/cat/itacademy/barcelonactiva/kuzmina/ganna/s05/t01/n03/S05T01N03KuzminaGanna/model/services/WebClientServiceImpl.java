package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n03.S05T01N03KuzminaGanna.model.services;

import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n03.S05T01N03KuzminaGanna.model.dto.FlowerDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.List;

@Service
@AllArgsConstructor
public class WebClientServiceImpl implements WebClientService{
  //  @Autowired



    public List getAll(){
        WebClient webClient = WebClient.create("http://localhost:9001");
        return webClient.get()
                .uri("/flower/getAll").
                header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(List.class)
                .block();

    }
    public FlowerDTO save(FlowerDTO flowerDTO){
        WebClient webClient = WebClient.create("http://localhost:9001");
        return webClient.post()
                .uri("/flower/add").
                header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(flowerDTO), FlowerDTO.class)
                .retrieve()
                .bodyToMono(FlowerDTO.class)
                .block();
    }

    @Override
    public Mono<FlowerDTO> findById(Integer id) {
        WebClient webClient = WebClient.create("http://localhost:9001");
        return webClient.get()
                .uri("/flower/getOne/"+id)
                .retrieve()
                .bodyToMono(FlowerDTO.class).onErrorResume(error->
                        Mono.error(error)
                        );
    }


    @Override

    public Mono<Void> delete(Integer id) {
         WebClient webClient = WebClient.create("http://localhost:9001");
        return webClient.delete()
                .uri("/flower/delete/"+id)
                .retrieve()
                .bodyToMono(Void.class);
    }

    @Override
    public FlowerDTO update(Integer id, FlowerDTO flowerDTO) {
        WebClient webClient = WebClient.create("http://localhost:9001");
        return webClient.put()
                .uri("/flower/update/"+id)
                .header(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(flowerDTO), FlowerDTO.class)
                .retrieve()
                .bodyToMono(FlowerDTO.class)
                .block();
    }


}
