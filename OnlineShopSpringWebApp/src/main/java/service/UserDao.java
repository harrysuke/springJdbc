package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import entity.User; 

@Service
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    public User getUserById(int id) {
        String sql = "SELECT * FROM user WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    public int deleteUser(int id) {
        String sql = "DELETE FROM user WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    public User login(String email, String password) {
        String sql = "SELECT * FROM user WHERE email=? AND password=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{email, password}, new BeanPropertyRowMapper<>(User.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public int register(User user) {
        String sql = "INSERT INTO user (firstname, lastname, email, password) VALUES (?,?,?,?)";
        return jdbcTemplate.update(
                sql,
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public int updateUser(User user) {
        String sql = "UPDATE user SET firstname=?, lastname=?, email=?, password=? WHERE id=?";
        return jdbcTemplate.update(
                sql,
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getPassword(),
                user.getId()
        );
    }

    public List<User> searchUsers(String keyword) {
        String sql = "SELECT * FROM user WHERE firstname LIKE ? OR lastname LIKE ? OR email LIKE ?";
        String searchKeyword = "%" + keyword + "%";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), searchKeyword, searchKeyword, searchKeyword);
    }
}
