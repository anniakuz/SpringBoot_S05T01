package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.model.domain;

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
public class Branch {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer pk_BranchID;
    @Column(nullable = false, unique = true,name="nameBranch")
    private String nameBranch;
    @Column(nullable = false, unique = true,name="countryBranch")
    private String countryBranch;
}
