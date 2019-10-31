package com.evan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenjijiang
 * @date 2019/10/31
 * @description
 */
@RestController
public class UserController {

	@RequestMapping("/userList")
	public Map<String,Object> getUser(){
		Map<String,Object> map = new HashMap<>();
		map.put("name","andy");
		return map;
	}
}
