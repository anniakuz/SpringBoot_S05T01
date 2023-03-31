package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.controllers;

import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.model.services.FlowerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/flower")
@AllArgsConstructor
public class FlowerRestController {

    private final FlowerService flowerService;

    @GetMapping("/getAll")
    public ResponseEntity<List<FlowerDTO>> getAllBranches(){
        List<FlowerDTO> flowersDTO = flowerService.getAllFlowersList();
        return ResponseEntity.status(HttpStatus.OK).body(flowersDTO);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOne (@PathVariable Integer id){
        FlowerDTO flowerDTO= null;
        try {
            flowerDTO = flowerService.findById(id);
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(flowerDTO);
    }

    @PostMapping("/add")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addOne(@RequestBody FlowerDTO flowerDTO){
        FlowerDTO savedFlowerDTO = flowerService.save(flowerDTO);
     if(savedFlowerDTO==null){
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Branch already exists");
     }
      return ResponseEntity.status(HttpStatus.CREATED).body(savedFlowerDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try{
            if(flowerService.findById(id)!=null){
                flowerService.delete(id);
            }
        }catch(IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(flowerService.getAllFlowersList());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody FlowerDTO flower, @PathVariable Integer id){
        try{
            FlowerDTO updatedFlower = flowerService.update(id,flower);
            return ResponseEntity.status(HttpStatus.CREATED).body(updatedFlower);
        }catch(IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }
}
