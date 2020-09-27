package com.m1z23r.minsoc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.m1z23r.minsoc.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByemail(String email);
	public Optional<User> findByEmail(@Param("email") String email);
}
