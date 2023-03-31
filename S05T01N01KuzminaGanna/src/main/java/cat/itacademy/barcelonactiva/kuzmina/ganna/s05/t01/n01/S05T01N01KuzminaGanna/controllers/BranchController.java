package cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.controllers;

import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.exceptions.HttpException;
import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.kuzmina.ganna.s05.t01.n01.S05T01N01KuzminaGanna.model.services.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/branch")
@AllArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @GetMapping("/getAll")
    public String getAllBranches(Model model){
        model.addAttribute("branches",branchService.getAllBranchesList());
        return "branches";
    }

    @GetMapping("/getOne/{id}")
    public String getBranchById(Model model, @PathVariable Integer id){
        try {
            model.addAttribute("branch", branchService.findById(id));
        }catch(HttpException e){
            model.addAttribute("error_message",e.getMessage());
            return "error";
        }
        return "branch";

    }
    @GetMapping("/add")
    public String add(Model model){
        try {
            BranchDTO branchDTO = new BranchDTO();
            model.addAttribute("branch",branchDTO);
        }catch(HttpException e){
            model.addAttribute("error_message",e.getMessage());
            return "error";
        }
        return "add_branch";
    }
    /*
    @PostMapping("/add")
    public RedirectView add(BranchDTO branchDTO){
        branchService.save(branchDTO);
        return new RedirectView("/getAll");
    }*/
    @PostMapping("/getAll")
    public String add(@ModelAttribute("branch") BranchDTO branchDTO) {
        branchService.save(branchDTO);
        return "redirect:/branch/getAll";
    }
    /*
    @GetMapping("/delete/{id}")
    public RedirectView delete(@PathVariable Integer id){
        branchService.delete(id);
        return new RedirectView("/fruit/getAll");
    }*/

    @GetMapping("/delete/{id}")
    public String deleteBranch(@PathVariable Integer id, Model model) {
        try {
            branchService.delete(id);
        }catch(HttpException e){
            model.addAttribute("error_message",e.getMessage());
            return "error";
        }
        return "redirect:/branch/getAll";
    }
    @GetMapping("/update/{id}")
    public String updateBranch(@PathVariable Integer id,Model model){
        try {
            BranchDTO branchDTO = branchService.findById(id);
            model.addAttribute("branch",branchDTO);
        }catch(HttpException e){
            model.addAttribute("error_message",e.getMessage());
            return "error";
        }
        return "update_branch";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("branch") BranchDTO branchDTO, Model model) {
        try {
            branchService.update(branchDTO);
        }catch(HttpException e){
            model.addAttribute("error_message",e.getMessage());
            return "error";
        }
        return "redirect:/branch/getAll";
    }
}
