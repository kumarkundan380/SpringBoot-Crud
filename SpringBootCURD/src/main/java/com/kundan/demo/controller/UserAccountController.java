package com.kundan.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kundan.demo.entity.UserAccount;
import com.kundan.demo.repository.UserAccountRepository;

@RestController
@RequestMapping("/account")
public class UserAccountController {
	
	@Autowired
	public UserAccountRepository userAccountRepository;
	
	@RequestMapping("/saveData")
	public UserAccount saveData(UserAccount userAccount) {
	
		System.out.println(userAccount.getUserName());
		userAccountRepository.save(userAccount);
		return userAccount;
	}
	
	@RequestMapping("/getDetails")
	public List getDetails() {
		List list=(List)userAccountRepository.findAll();
		System.out.println(list.size());
		return list;
	}

}
