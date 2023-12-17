package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Customer;
import service.CustomerDao_usingHibernate;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	private final CustomerDao_usingHibernate customerDao;
	
	@Autowired
	public CustomerController(CustomerDao_usingHibernate customerDao) {
		this.customerDao = customerDao;
	}
	
	@GetMapping("/addCustomer")
	public String showNewCustomerForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "formaddcustomer";
	}
	@PostMapping("/add")
	public String add(@ModelAttribute("customer") Customer customer) {
	    customerDao.createCustomer(customer);
	    return "redirect:/customer/listCustomer";
	}
	@RequestMapping("/listCustomer")
	public String getAllCustomers(Model model) {
		List<Customer> customerList = customerDao.getall();
		model.addAttribute("customerList", customerList);
		return "listofallcustomers";
	}
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable int id, Model model) {
		Customer customer = customerDao.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "formeditcustomer";
		
	}
	@PostMapping("/update")
	public String updateCustomer(@ModelAttribute("customer") Customer customer) {
		int rowAffected = customerDao.updateCustomer(customer);
		return "redirect:/customer/listCustomer";
	}
	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable int id) {
		customerDao.deleteCustomer(id);
		return "redirect:/customer/listCustomer";
	}
}
