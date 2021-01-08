package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.test;
import com.example.demo.service.testService;
import com.example.demo.util.CsvUtils;

@Controller
@RequestMapping("/upload")
public class CsvUploadController {

	@Autowired
    JdbcTemplate jdbcTemplate;

	@Autowired
	testService service;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("fileData") MultipartFile multipartFile){

    	try {
			service.saveAll(CsvUtils.read(test.class, multipartFile.getInputStream()));
		} catch (Exception e) {
			e.printStackTrace();
			return "systemerror";
		}

    	return "redirect:/test";
    }
}
