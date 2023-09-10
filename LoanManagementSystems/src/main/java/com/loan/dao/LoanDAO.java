package com.loan.dao;

import java.util.List;

import com.loan.model.Customer;
import com.loan.model.LoanApplicantNominees;
import com.loan.model.LoanApplicants;

public interface LoanDAO {
	void persist(LoanApplicants l);

	List<LoanApplicants> getAllEmployees();

	void persiste(LoanApplicantNominees l);

	List<LoanApplicantNominees> getAllNominees();

	void persistCustomer(Customer l);

	List<Customer> getAllCustomers();
	
	void edite(LoanApplicants u);
}
