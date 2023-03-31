package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.model.dto;

import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.model.domain.Branch;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.model.dto.TypeBranch.EU;
import static cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.model.dto.TypeBranch.notEU;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BranchDTO {
    private Integer pk_BranchID;
    private String nameBranch;
    private String countryBranch;
    private TypeBranch typeBranch;

    public static List<String> listCountriesEU(){
        List<String> countriesEU = List.of( "Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus",
                "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary",
                "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland",
                "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden");
        return countriesEU;
    }




    public static BranchDTO of(Branch entity){
        return BranchDTO.builder().pk_BranchID(entity.getPk_BranchID()).nameBranch(entity.getNameBranch())
                .countryBranch(entity.getCountryBranch()).typeBranch(getType(entity.getCountryBranch())).build();

    }

    public static TypeBranch getType(String countryName){
        return listCountriesEU().stream()
                .filter(country->country.equalsIgnoreCase(countryName)).toList().size()>0?EU:notEU;
    }
}
