package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.model.services;

import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.exceptions.HttpException;
import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.model.domain.Branch;
import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.model.repository.BranchRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BranchServiceImpl implements BranchService{


    private final BranchRepository branchRepository;

    /*
    public BranchDTO convertEntityToDTO(Branch entity){
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setPk_BranchID(entity.getPk_BranchID());
        branchDTO.setNameBranch(entity.getNameBranch());
        branchDTO.setCountryBranch(entity.getCountryBranch());
        branchDTO.setTypeBranch(branchDTO.);
        return branchDTO;
    } */

    @Override
    public List<BranchDTO> getAllBranchesList() {
        return branchRepository.findAll().stream().map(BranchDTO::of).collect(Collectors.toList());
    }


    @Override
    public BranchDTO save(BranchDTO branchDTO) {
        if(branchRepository.getBranchByNameBranchAndCountryBranch(branchDTO.getNameBranch(), branchDTO.getCountryBranch())!=null) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Branch already exists");
        }
        Branch branch = Branch.builder().nameBranch(branchDTO.getNameBranch()).countryBranch(branchDTO.getCountryBranch()).build();//new Branch(branchDTO.getPk_BranchID(),branchDTO.getNameBranch(),branchDTO.getCountryBranch());
        return BranchDTO.of(branchRepository.save(branch));
    }
    @Override
    public BranchDTO findById(Integer id) {
        return branchRepository.findById(id).map(BranchDTO::of).orElseThrow(()-> new HttpException(HttpStatus.NOT_FOUND,
                "Could not find any branch with ID "+id));
    }
    @Override
    public void delete(Integer id) {
        try{
            if(branchRepository.findById(id)!=null) {
                branchRepository.deleteById(id);
            }
        }catch(RuntimeException ex){
            throw new HttpException(HttpStatus.NOT_FOUND,"Could not find any branch with ID "+id);
        }
    }
    @Override
    public BranchDTO update(BranchDTO branchDTO) {
        Branch branchUpdated = Branch.builder().pk_BranchID(branchDTO.getPk_BranchID()).nameBranch(branchDTO.getNameBranch()).countryBranch(branchDTO.getCountryBranch()).build();
        return BranchDTO.of(branchRepository.save(branchUpdated));
    }
}
