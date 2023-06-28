package com.yash.ems.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yash.ems.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByEmail(String email);

}
