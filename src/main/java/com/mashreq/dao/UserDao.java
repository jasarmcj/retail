package com.mashreq.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mashreq.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

}
