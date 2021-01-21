package com.example.demo.form;

import com.example.demo.model.Csv;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CsvSearchForm extends Csv {
	private String ofid;
	private String sid;
	private String gid;
	private String nen;
	private String tsuki;
}
