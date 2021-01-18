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

import com.example.demo.model.Office;
import com.example.demo.service.OfficeService;

@Controller
@RequestMapping("/office")
public class OfficeController {
	@Autowired
	private OfficeService officeService;

	@GetMapping
	  public String officeIndex(Model model) {
	    List<Office> offices = officeService.findAll();
	    model.addAttribute("offices", offices);
	    return "officeIndex";
	}

	@GetMapping("officeNew")
	public String newOffice(Model model) {
		return "officeNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Office office = officeService.findOne(id);
		model.addAttribute("office",office);
		return "officeEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Office office) {
		officeService.save(office);
		return "redirect:/office";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Office office) {
        office.setId(id);
        officeService.save(office);
        return "redirect:/office";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        officeService.delete(id);
        return "redirect:/office";
    }
}