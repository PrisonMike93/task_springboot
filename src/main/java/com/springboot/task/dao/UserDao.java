package com.springboot.task.dao;


import com.springboot.task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao extends JpaRepository<User, Long> {



}
