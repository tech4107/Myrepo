package com.centraprise.hrmodule.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/")
	public String getEmployeeList() {
		return "employee";
	}

	@GetMapping("/signin")
	public String getEmp() {
		return "employee";
	}
}
