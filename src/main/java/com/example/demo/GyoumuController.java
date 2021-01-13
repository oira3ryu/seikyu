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

import com.example.demo.model.Gyoumu;
import com.example.demo.service.GyoumuService;

@Controller
@RequestMapping("/gyoumu")
public class GyoumuController {
	@Autowired
	private GyoumuService gyoumuService;

	@GetMapping
	  public String gyoumuIndex(Model model) {
	    List<Gyoumu> gyoumus = gyoumuService.findAll();
	    model.addAttribute("gyoumus", gyoumus);
	    return "gyoumuIndex";
	}

	@GetMapping("gyoumuNew")
	public String newgyoumu(Model model) {
		return "gyoumuNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Gyoumu gyoumu = gyoumuService.findOne(id);
		model.addAttribute("gyoumu",gyoumu);
		return "gyoumuEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Gyoumu gyoumu) {
		gyoumuService.save(gyoumu);
		return "redirect:/gyoumu";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Gyoumu gyoumu) {
        gyoumu.setG_id(id);
        gyoumuService.save(gyoumu);
        return "redirect:/gyoumu";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        gyoumuService.delete(id);
        return "redirect:/gyoumu";
    }
}