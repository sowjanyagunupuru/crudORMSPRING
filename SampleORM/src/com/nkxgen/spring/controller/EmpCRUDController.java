package com.nkxgen.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nkxgen.spring.orm.model.Employee;
import com.nkxgen.spring.orm.service.EmpService;

@Controller
public class EmpCRUDController {

	EmpService eserv;

	@Autowired
	public EmpCRUDController(EmpService empserv) {
		eserv = empserv;
	}

	@RequestMapping(value = "/emplist", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		System.out.println("Employees List JSP Requested");
		List<Employee> empList = eserv.listAll();
		model.addAttribute("elist", empList);
		return "emplist";
	}

	@RequestMapping(value = "/addnewemp", method = RequestMethod.GET)
	public String addNewEmployee(Model model) {
		System.out.println("Add New Emp JSP Requested");
		return "newemp";
	}

	@RequestMapping(value = "/savenewemp", method = RequestMethod.POST)
	public String saveNewEmployee(@Validated Employee emp, Model model) {
		System.out.println("Save New Employee Page Requested");
		eserv.add(emp);
		model.addAttribute("emp", emp);
		return "saveempsuccess";
	}

	@RequestMapping(value = "/updateemp", method = RequestMethod.GET)
	public String updateEmployee(@Validated Employee emp, Model model) {
		System.out.println("update Employee Page Requested");
		return "updatenewemp";
	}

	@RequestMapping(value = "/updatenewem", method = RequestMethod.POST)
	public String updatenewEmployee(@Validated Employee emp, Model model) {
		System.out.println("update New Employee Page Requested");
		// get all employees from DAO
		eserv.updateEmp(emp);
		model.addAttribute("emp", emp);
		return "updateempsuccess";
	}

	@RequestMapping(value = "/deleteemp", method = RequestMethod.GET)
	public String deleteemp(Model model) {
		System.out.println("To delete Employee Page Requested");
		return "deletenewemp";
	}

	@RequestMapping(value = "/deleteem", method = RequestMethod.POST)
	public String deleterecord(@Validated Employee emp, Model model) {
		System.out.println("delete Employee Page Requested");
		eserv.deleteEmp(emp);
		model.addAttribute("emp", emp);
		return "deleteempsuccess";
	}

	@RequestMapping(value = "/getemp", method = RequestMethod.GET)
	public String getemp(@Validated Employee emp, Model model) {
		System.out.println("Employee JSP Requested");
		return "getempidview";
	}

	@RequestMapping(value = "/getem", method = RequestMethod.POST)
	public String deleterecordemp(@Validated Employee emp, Model model) {
		System.out.println("Employe detials Page Requested");
		Employee b = eserv.getById(emp.getEmpNo());
		model.addAttribute("e", b);
		return "getempid";

	}
}