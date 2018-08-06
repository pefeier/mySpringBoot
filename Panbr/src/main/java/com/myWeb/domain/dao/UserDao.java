package main.java.com.myWeb.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.myWeb.domain.Entity.User;

public interface UserDao extends JpaRepository<User, Long> {

	    User findByUserName(String userName);

	    User findByUserNameOrEmail(String username, String email);
	   
}
