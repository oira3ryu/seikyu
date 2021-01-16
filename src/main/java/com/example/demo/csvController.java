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

import com.example.demo.form.CsvSearchForm;
import com.example.demo.model.Csv;
import com.example.demo.model.Gyoumu;
import com.example.demo.model.Nen;
import com.example.demo.model.Syubetsu;
import com.example.demo.model.Tsuki;
import com.example.demo.service.CsvService;
import com.example.demo.service.GyoumuService;
import com.example.demo.service.NenService;
import com.example.demo.service.SyubetsuService;
import com.example.demo.service.TsukiService;


@Controller
@RequestMapping("/csv")
public class csvController {
	@Autowired
	private CsvService csvService;

	@Autowired
	private GyoumuService gyoumuService;

	@Autowired
	private SyubetsuService syubetsuService;

	@Autowired
	private NenService nenService;

	@Autowired
	private TsukiService tsukiService;


	@GetMapping
	  public String csvIndex(Model model) {
	    List<Csv> csvs = csvService.findAll();
	    model.addAttribute("csv", csvs);

	    List<Syubetsu> syubetsus = syubetsuService.findAll();
	    model.addAttribute("syubetsu", syubetsus);

	    List<Gyoumu> gyoumus = gyoumuService.findAll();
	    model.addAttribute("gyoumu", gyoumus);

	    List<Nen> nens = nenService.findAll();
	    model.addAttribute("nen", nens);

	    List<Tsuki> tsukis = tsukiService.findAll();
	    model.addAttribute("tsuki", tsukis);

	    model.addAttribute("searchParam", new Csv());

	    return "csvIndex";
	}

	@GetMapping("csvNew")
	public String newcsv(Model model) {
		return "csvNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Csv csv = csvService.findOne(id);
		model.addAttribute("csv",csv);
		return "csvEdit";
	}

	@PostMapping("search")
	public String search(@ModelAttribute("searchParam") CsvSearchForm form, Model model) {

		List<Csv> csvs = csvService.findByForm(form);
		model.addAttribute("csv", csvs);

//		List<Csv> csvs = csvService.findAll();
//	    model.addAttribute("csv", csvs);

	    List<Syubetsu> syubetsus = syubetsuService.findAll();
	    model.addAttribute("syubetsu", syubetsus);

	    List<Gyoumu> gyoumus = gyoumuService.findAll();
	    model.addAttribute("gyoumu", gyoumus);

	    List<Nen> nens = nenService.findAll();
	    model.addAttribute("nen", nens);

	    List<Tsuki> tsukis = tsukiService.findAll();
	    model.addAttribute("tsuki", tsukis);

	    model.addAttribute("searchParam", form);

	    return "csvIndex";
	}

	@PostMapping
	public String create(@ModelAttribute Csv csv) {
		csvService.save(csv);
		return "redirect:/csv";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Csv csv) {
        csv.setId(id);
        csvService.save(csv);
        return "redirect:/csv";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        csvService.delete(id);
        return "redirect:/csv";
    }
}