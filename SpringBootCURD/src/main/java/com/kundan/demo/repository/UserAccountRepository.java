package com.kundan.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.kundan.demo.entity.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount,Integer>{

}
