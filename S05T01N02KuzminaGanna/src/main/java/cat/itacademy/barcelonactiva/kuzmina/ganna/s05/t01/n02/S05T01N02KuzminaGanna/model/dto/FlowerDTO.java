package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.model.dto;

import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.model.domain.Flower;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.model.dto.TypeFlower.EU;
import static cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.model.dto.TypeFlower.notEU;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FlowerDTO {
    private Integer pk_FlowerID;
    private String nameFlower;
    private String countryFlower;
    private TypeFlower typeFlower;

    public static List<String> listCountriesEU(){
        List<String> countriesEU = List.of( "Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus",
                "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary",
                "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland",
                "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden");
        return countriesEU;
    }




    public static FlowerDTO of(Flower entity){
        return FlowerDTO.builder().pk_FlowerID(entity.getPk_FlowerID()).nameFlower(entity.getNameFlower())
                .countryFlower(entity.getCountryFlower()).typeFlower(getType(entity.getCountryFlower())).build();

    }

    public static TypeFlower getType(String countryName){
        return listCountriesEU().stream()
                .filter(country->country.equalsIgnoreCase(countryName)).toList().size()>0?EU:notEU;
    }
}
