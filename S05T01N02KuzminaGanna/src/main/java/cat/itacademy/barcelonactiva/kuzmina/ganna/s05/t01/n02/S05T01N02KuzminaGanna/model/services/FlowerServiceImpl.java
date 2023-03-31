package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.model.services;

import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.exceptions.HttpException;
import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.model.domain.Flower;
import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.model.repository.FlowerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlowerServiceImpl implements FlowerService {


    private final FlowerRepository flowerRepository;

    @Override
    public List<FlowerDTO> getAllFlowersList() {
        return flowerRepository.findAll().stream().map(FlowerDTO::of).collect(Collectors.toList());
    }


    @Override
    public FlowerDTO save(FlowerDTO flowerDTO) {
        if(flowerRepository.getFlowerByNameFlowerAndCountryFlower(flowerDTO.getNameFlower(), flowerDTO.getCountryFlower())!=null) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Flower already exists");
        }
        Flower flower = Flower.builder().nameFlower(flowerDTO.getNameFlower()).countryFlower(flowerDTO.getCountryFlower()).build();
        return FlowerDTO.of(flowerRepository.save(flower));
    }

    @Override
    public FlowerDTO findById(Integer id) {
        return flowerRepository.findById(id).map(FlowerDTO::of).orElseThrow(()-> new HttpException(HttpStatus.NOT_FOUND,
                "Could not find any Flower with ID "+id));
    }


    @Override
    public void delete(Integer id) {
        try{
            if(flowerRepository.findById(id)!=null) {
                flowerRepository.deleteById(id);
            }
        }catch(RuntimeException ex){
            throw new HttpException(HttpStatus.NOT_FOUND,"Could not find any Flower with ID "+id);
        }
    }

    @Override
    public FlowerDTO update(Integer id, FlowerDTO flowerDTO) {
        FlowerDTO flowerToSave = flowerRepository.findById(id).map(FlowerDTO::of).orElseThrow(()-> new HttpException(HttpStatus.NOT_FOUND,
                "Could not find any Flower with ID "+id));
        flowerToSave.setNameFlower(flowerDTO.getNameFlower());
        flowerToSave.setCountryFlower(flowerDTO.getCountryFlower());
        Flower flowerUpdated = Flower.builder().pk_FlowerID(id).nameFlower(flowerToSave.getNameFlower()).countryFlower(flowerToSave.getCountryFlower()).build();
        return FlowerDTO.of(flowerRepository.save(flowerUpdated));
    }
}
