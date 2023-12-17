package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import entity.Product;

@Service
public class ProductDao_usingJdbcTemplate {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Product> getall() {
		String sql="SELECT * FROM product";
		List<Product> prodList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
		return prodList;
	}
	
	public List<Product> getAll() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }
	
	public Product getProductById(int id) {
        String sql = "SELECT * FROM product WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Product>(Product.class));
    }

    public int createProduct(Product product) {
        String sql = "INSERT INTO product (name, price, quantity) VALUES (?, ?, ?)";
        int rowAffected = jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getQuantity());
        return rowAffected;
    }

    public int deleteProduct(int id) {
        String sql = "DELETE FROM product WHERE id=?";
        int nowAffected = jdbcTemplate.update(sql, id);
        return nowAffected;
    }
    
    public int updateProduct(Product product) {
    	String sql = "UPDATE product SET name=?, price=?, quantity=? WHERE id=?";
    	int rowAffected = jdbcTemplate.update(
    			sql,
    			product.getName(),
    			product.getPrice(),
    			product.getQuantity(),
    			product.getId()
    			);
    	return rowAffected;
    }
    
    public List<Product> searchProducts(String keyword) {
        String sql = "SELECT * FROM product WHERE name LIKE ?";
        String searchKeyword = "%" + keyword + "%";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), searchKeyword);
    }
}
