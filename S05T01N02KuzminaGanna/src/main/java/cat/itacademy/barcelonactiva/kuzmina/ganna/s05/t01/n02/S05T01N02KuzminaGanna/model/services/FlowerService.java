package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.model.services;

import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.model.dto.FlowerDTO;

import java.util.List;

public interface FlowerService {
    public List<FlowerDTO> getAllFlowersList();
    public FlowerDTO save(FlowerDTO flowerDTO);
    public FlowerDTO findById(Integer id);
    public void delete(Integer id);
    public FlowerDTO update(Integer id, FlowerDTO flowerDTO);
}
