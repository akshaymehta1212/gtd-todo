package com.gtd.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gtd.todo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
