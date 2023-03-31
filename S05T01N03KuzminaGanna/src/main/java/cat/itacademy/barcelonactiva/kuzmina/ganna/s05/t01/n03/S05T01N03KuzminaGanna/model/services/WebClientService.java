package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n03.S05T01N03KuzminaGanna.model.services;

import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n03.S05T01N03KuzminaGanna.model.dto.FlowerDTO;
import reactor.core.publisher.Mono;

import java.util.List;

public interface WebClientService {
    public List<FlowerDTO> getAll();
    //public FlowerDTO findById(Integer id);
    public Mono<FlowerDTO> findById(Integer id);
    public FlowerDTO save(FlowerDTO flowerDTO);
    public Mono<Void> delete(Integer id);
    public FlowerDTO update(Integer id, FlowerDTO flowerDTO);
}
