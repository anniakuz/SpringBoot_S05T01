package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n03.S05T01N03KuzminaGanna.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FlowerDTO implements Serializable {
    private Integer pk_FlowerID;
    private String nameFlower;
    private String countryFlower;
    private TypeFlower typeFlower;

}
