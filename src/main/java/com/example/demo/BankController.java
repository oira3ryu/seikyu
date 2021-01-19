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

import com.example.demo.model.Bank;
import com.example.demo.service.BankService;

@Controller
@RequestMapping("/bank")
public class BankController {
	@Autowired
	private BankService bankService;

	@GetMapping
	  public String bankIndex(Model model) {
	    List<Bank> banks = bankService.findAll();
	    model.addAttribute("banks", banks);
	    return "bankIndex";
	}

	@GetMapping("bankNew")
	public String newBank(Model model) {
		return "bankNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Bank bank = bankService.findOne(id);
		model.addAttribute("bank",bank);
		return "bankEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Bank bank) {
		bankService.save(bank);
		return "redirect:/bank";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Bank bank) {
        bank.setId(id);
        bankService.save(bank);
        return "redirect:/bank";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        bankService.delete(id);
        return "redirect:/bank";
    }
}