package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.model.services;

import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.model.dto.BranchDTO;

import java.util.List;

public interface BranchService {
    public List<BranchDTO> getAllBranchesList();
    public BranchDTO save(BranchDTO branchDTO);
    public BranchDTO findById(Integer id);
    public void delete(Integer id);
    public BranchDTO update(BranchDTO branchDTO);
}
