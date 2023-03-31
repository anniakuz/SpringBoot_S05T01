package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n03.S05T01N03KuzminaGanna.controllers;


import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n03.S05T01N03KuzminaGanna.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n03.S05T01N03KuzminaGanna.model.services.WebClientService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;


@RestController
@RequestMapping("/flower")
@AllArgsConstructor
public class FlowerRestController {

    private final WebClientService webClientService;

    //WebClient webClient = WebClient.create("http://localhost:9001");
    @GetMapping("/clientFlowerGetAll")
    public ResponseEntity<List<FlowerDTO>> getAllBranches(){
        // WebClient webClient = WebClient.create("http://localhost:9001");
        List<FlowerDTO> response = webClientService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/clientFlowerGetOne/{id}")
    public ResponseEntity<?> getOne (@PathVariable Integer id){
        FlowerDTO flowerDTO= null;
       try {
            flowerDTO = webClientService.findById(id).block();
        }catch (WebClientResponseException ex){

           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(flowerDTO);
    }

    @PostMapping("/clientFlowerAdd")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addOne(@RequestBody FlowerDTO flowerDTO){
        FlowerDTO savedFlowerDTO = webClientService.save(flowerDTO);
     if(savedFlowerDTO==null){
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Branch already exists");
     }
      return ResponseEntity.status(HttpStatus.CREATED).body(savedFlowerDTO);
    }

    @DeleteMapping("/clientFlowerDelete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try{
           // if(webClientService.findById(id)!=null){
                webClientService.delete(id).block();
            //}
        }catch(IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(webClientService.getAll());
    }

    @PutMapping("/clientFlowerUpdate/{id}")
    public ResponseEntity<?> update(@RequestBody FlowerDTO flower, @PathVariable Integer id){
        FlowerDTO updatedFlower = null;
        try{
            if(webClientService.findById(id)!=null) {
                updatedFlower = webClientService.update(id, flower);
            }
        }catch(IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedFlower);
    }
}
