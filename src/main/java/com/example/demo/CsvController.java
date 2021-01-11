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

import com.example.demo.model.Csv;
import com.example.demo.service.CsvService;

@Controller
@RequestMapping("/Csv")
public class CsvController {
	@Autowired
	private CsvService CsvService;

	@GetMapping
	  public String csvIndex(Model model) {
	    List<Csv> csvs = CsvService.findAll();
	    model.addAttribute("csvs", csvs);
	    return "csvIndex";
	}

	@GetMapping("csvNew")
	public String newCsv(Model model) {
		return "csvNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Csv csv = CsvService.findOne(id);
		model.addAttribute("csv",csv);
		return "csvEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Csv csv) {
		CsvService.save(csv);
		return "redirect:/Csv";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Csv csv) {
        csv.setId(id);
        CsvService.save(csv);
        return "redirect:/Csv";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        CsvService.delete(id);
        return "redirect:/Csv";
    }
}