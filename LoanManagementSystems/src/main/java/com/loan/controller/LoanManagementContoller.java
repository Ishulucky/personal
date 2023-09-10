package com.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loan.model.Customer;
import com.loan.model.InputLoanApplicants;
import com.loan.model.LoanApplicantNominees;
import com.loan.model.LoanApplicants;
import com.loan.service.LoanService;

@Controller
public class LoanManagementContoller {

	LoanService loanserv;

	@Autowired
	public LoanManagementContoller(LoanService loanserv) {
		this.loanserv = loanserv;
	}

	/**
	 * selects the Add New Employee view to render by returning its name.
	 */
	@RequestMapping(value = "/loanlist", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		System.out.println("loan List JSP Requested");

		List<LoanApplicants> l = loanserv.listAll();

		model.addAttribute("list", l);

		return "loanlist";
	}

	@RequestMapping(value = "/addloan", method = RequestMethod.GET)
	public String addNewEmployee(Model model) {
		System.out.println("Add a record");
		return "addLoanApplicants";
	}

	@RequestMapping(value = "/tabs", method = RequestMethod.GET)
	public String tabs(Model model) {
		System.out.println("Add a record");
		return "tab";
	}
	
	@RequestMapping(value = "/emi", method = RequestMethod.GET)
	public String emiCalculate(Model model) {
		System.out.println("success a emi calculation check");
		return "EmiCalculation";
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage(Model model) {
		System.out.println("home page is started");
		return "list";
	}

	@RequestMapping(value = "/Editapplicant", method = RequestMethod.GET)
	public String View(LoanApplicants la,Model model) {
		loanserv.edit(la);
		model.addAttribute("llist", la);
		return "statuschange";
	}
	
	
	
	@RequestMapping(value = "/updation", method = RequestMethod.GET)
	public String updation(@Validated InputLoanApplicants l, Model model) {
		System.out.println("success");
		Customer c = new Customer();
		LoanApplicants a = new LoanApplicants();
		LoanApplicantNominees b = new LoanApplicantNominees();

		c.setFirstName(l.getFirstName());
		c.setAddress(l.getAddress());
		c.setLastName(l.getLastName());
		c.setDateOfBirth(l.getDateOfBirth());
		c.setPanNumber(l.getPanNumber());
		c.setMobileNumber(l.getMobileNumber());
		c.setGuardianName(l.getGuardianName());
		b.setNominee(l.getNominee());
		b.setRelation(l.getRelation());
		a.setEmiRangeFrom(l.getEmiRangeFrom());
		a.setLoanTypeId(l.getCid());
		a.setApplicationDate(l.getApplicationDate());
		a.setLoanAmount(l.getLoanAmount());
		a.setEmiRangeTo(l.getEmiRangeTo());
		a.setNumberOfMonthsRequested(l.getNumberOfMonthsRequested());
		loanserv.addCustomer(c);
		a.setCustomer(c.getCid());
		loanserv.add(a);

		b.setNid(a.getId());
		loanserv.addn(b);

		return "updated";
	}

	// @RequestMapping(value = "/save1", method = RequestMethod.GET)
	// public String saveNewEmployee1(@Validated InputLoanApplicants data, Model model) {
	// System.out.println("Save New Employee Page Requested");
	// // get all employees from DAO
	// LoanApplicants l = new LoanApplicants();
	// l.transfer(data);
	//
	// loanserv.add(l);
	//
	// model.addAttribute("loan", l);
	//
	// return "save";
	// }

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String saveNewEmployee(@Validated LoanApplicants l, Model model) {
		System.out.println("Save New Employee Page Requested");
		loanserv.add(l);
		model.addAttribute("loan", l);

		return "save";
	}

	@RequestMapping(value = "/addnominee", method = RequestMethod.GET)
	public String addNewNominee(Model model) {
		System.out.println("Add a record");
		return "addNominee";
	}

	@RequestMapping(value = "/savenominee", method = RequestMethod.GET)
	public String saveNewEmployee(@Validated LoanApplicantNominees l, Model model) {
		System.out.println("Save New Employee Page Requested");
		loanserv.addn(l);
		model.addAttribute("nominee", l);

		return "savenominee";
	}

	@RequestMapping(value = "/addcustomer", method = RequestMethod.GET)
	public String addNewCustomer(Model model) {
		System.out.println("Add a record");
		return "addcustomer";
	}

	@RequestMapping(value = "/savecustomer", method = RequestMethod.GET)
	public String saveNewCustomer(@Validated Customer l, Model model) {
		System.out.println("Save New Employee Page Requested");
		loanserv.addCustomer(l);
		model.addAttribute("customer", l);

		return "savecustomer";
	}

}