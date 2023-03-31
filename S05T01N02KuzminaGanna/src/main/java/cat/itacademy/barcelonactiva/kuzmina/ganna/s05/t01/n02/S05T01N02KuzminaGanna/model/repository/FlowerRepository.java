package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.model.repository;

import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n02.S05T01N02KuzminaGanna.model.domain.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Integer> {
    public Flower getFlowerByNameFlowerAndCountryFlower(String nameFlower, String countryFlower);
    //query on HQL
    //@Query(value="select b from Branch b where b.countryBranch=:countryBranch and b.nameBranch=:nameBranch")
    //public Branch getBranchByNameAndCountry(String nameBranch,String countryBranch);
    //nativeQuery
    //Query(value="select * from branches where country_branch=:countryBranch and name_branch=:nameBranch",nativeQuery = true)
    //public Branch getBranchByNameAndCountry(String nameBranch,String countryBranch);

}
