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

import com.example.demo.model.Syubetsu;
import com.example.demo.service.SyubetsuService;

@Controller
@RequestMapping("/syubetsu")
public class SyubetsuController {
	@Autowired
	private SyubetsuService syubetsuService;

	@GetMapping
	  public String syubetsuIndex(Model model) {
	    List<Syubetsu> syubetsus = syubetsuService.findAll();
	    model.addAttribute("syubetsus", syubetsus);
	    return "syubetsuIndex";
	}

	@GetMapping("syubetsuNew")
	public String newsyubetsu(Model model) {
		return "syubetsuNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Syubetsu syubetsu = syubetsuService.findOne(id);
		model.addAttribute("syubetsu",syubetsu);
		return "syubetsuEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Syubetsu syubetsu) {
		syubetsuService.save(syubetsu);
		return "redirect:/syubetsu";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Syubetsu syubetsu) {
        syubetsu.setPs_id(id);
        syubetsuService.save(syubetsu);
        return "redirect:/syubetsu";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        syubetsuService.delete(id);
        return "redirect:/syubetsu";
    }
}