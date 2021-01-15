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

import com.example.demo.model.Tsuki;
import com.example.demo.service.TsukiService;

@Controller
@RequestMapping("/tsuki")
public class TsukiController {
	@Autowired
	private TsukiService tsukiService;

	@GetMapping
	  public String NenIndex(Model model) {
	    List<Tsuki> tsukis = tsukiService.findAll();
	    model.addAttribute("tsukis", tsukis);
	    return "tsukiIndex";
	}

	@GetMapping("nenNew")
	public String newNen(Model model) {
		return "nenNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Tsuki tsuki = tsukiService.findOne(id);
		model.addAttribute("tsuki",tsuki);
		return "tsukiEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Tsuki tsuki) {
		tsukiService.save(tsuki);
		return "redirect:/tsuki";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Tsuki tsuki) {
		tsuki.setId(id);
		tsukiService.save(tsuki);
        return "redirect:/tsuki";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
    	tsukiService.delete(id);
        return "redirect:/tsuki";
    }
}