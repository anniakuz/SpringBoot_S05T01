package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name="branches")
public class Flower {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer pk_FlowerID;
    private String nameFlower;
    private String countryFlower;
}
