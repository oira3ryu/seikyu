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

import com.example.demo.model.test;
import com.example.demo.service.testService;

@Controller
@RequestMapping("/test")
public class testController {
	@Autowired
	private testService testService;

	@GetMapping
	  public String testIndex(Model model) {
	    List<test> tests = testService.findAll();
	    model.addAttribute("tests", tests);
	    return "testIndex";
	}

	@GetMapping("testNew")
	public String newtest(Model model) {
		return "testNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		test test = testService.findOne(id);
		model.addAttribute("test",test);
		return "testEdit";
	}

	@PostMapping
	public String create(@ModelAttribute test test) {
		testService.save(test);
		return "redirect:/test";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute test test) {
        test.setId(id);
        testService.save(test);
        return "redirect:/test";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        testService.delete(id);
        return "redirect:/test";
    }
}