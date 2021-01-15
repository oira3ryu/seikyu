package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Nen;
import com.example.demo.service.NenService;

@Controller
@RequestMapping("/nen")
public class NenController {
	@Autowired
	private NenService nenService;

	@GetMapping
	  public String NenIndex(Model model) {
	    List<Nen> nens = nenService.findAll();
	    model.addAttribute("nens", nens);
	    return "nenIndex";
	}

	@GetMapping("nenNew")
	public String newNen(Model model) {
		return "nenNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Nen nen = nenService.findOne(id);
		model.addAttribute("nen",nen);
		return "nenEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Nen nen) {
		nenService.save(nen);
		return "redirect:/nen";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Nen nen) {
        nen.setId(id);
        nenService.save(nen);
        return "redirect:/nen";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        nenService.delete(id);
        return "redirect:/nen";
    }
}