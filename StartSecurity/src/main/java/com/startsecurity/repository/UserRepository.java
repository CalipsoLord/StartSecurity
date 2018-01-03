package com.startsecurity.repository;

import org.springframework.data.repository.CrudRepository;

import com.startsecurity.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
