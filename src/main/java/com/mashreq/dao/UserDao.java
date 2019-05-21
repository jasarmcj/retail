package com.mashreq.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mashreq.entity.User;

/**
 * 
 * @author jasar_jamaludheen
 * 
 * User dao
 *
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

}
