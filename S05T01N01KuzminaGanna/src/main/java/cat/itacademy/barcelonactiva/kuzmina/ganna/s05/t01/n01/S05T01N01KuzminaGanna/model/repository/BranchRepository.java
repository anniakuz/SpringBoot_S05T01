package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.model.repository;

import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.model.domain.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
    public Branch getBranchByNameBranchAndCountryBranch(String nameBranch,String countryBranch);
    //query on HQL
    //@Query(value="select b from Branch b where b.countryBranch=:countryBranch and b.nameBranch=:nameBranch")
    //public Branch getBranchByNameAndCountry(String nameBranch,String countryBranch);
    //nativeQuery
    //Query(value="select * from branches where country_branch=:countryBranch and name_branch=:nameBranch",nativeQuery = true)
    //public Branch getBranchByNameAndCountry(String nameBranch,String countryBranch);

}
