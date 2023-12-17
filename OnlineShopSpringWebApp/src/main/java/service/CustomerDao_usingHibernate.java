package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import entity.Customer;

@Service
public class CustomerDao_usingHibernate {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Customer> getall(){
		String sql = "SELECT * FROM customer";
		List<Customer> customerList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));
		return customerList;
	}
	
	public Customer getCustomerById(int id) {
		String sql = "SELECT * FROM customer WHERE id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Customer>(Customer.class));
	}
	
	public int createCustomer(Customer customer) {
	    String sql = "INSERT INTO customer (firstname, lastname, email) VALUES (?, ?, ?)";
	    int rowAffected = jdbcTemplate.update(sql, customer.getFirstname(), customer.getLastname(), customer.getEmail());
	    return rowAffected;
	}
	
	public int deleteCustomer(int id) {
		String sql = "DELETE FROM customer WHERE id=?";
		int nowAffected = jdbcTemplate.update(sql, id);
		return nowAffected;
	}
	
	public int updateCustomer(Customer customer) {
		String sql = "UPDATE customer SET firstname=?, lastname=?, email=? WHERE id=?";
		int rowAffected = jdbcTemplate.update(
				sql,
				customer.getFirstname(),
				customer.getLastname(),
				customer.getEmail(),
				customer.getId()
				);
		return rowAffected;
	}
	
	public List<Customer> searchCustomer(String keyword){
		String sql = "SELECT * FROM customer WHERE id=?";
		String searchKeyword = "%"+keyword+"%";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class), searchKeyword);
	}

}
