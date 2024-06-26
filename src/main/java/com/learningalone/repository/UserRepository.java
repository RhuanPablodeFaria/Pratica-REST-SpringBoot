package com.learningalone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.learningalone.entyti.User;

public interface UserRepository extends JpaRepository<User, Long>{
	@Modifying
    @Transactional
	@Query("UPDATE User u SET activeUser=false WHERE u.id = :id")
	Integer updateActiveUserById(@Param("id") Long id);
}
