package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CalcService;


@RestController
public class CalcController {

	@Autowired
	private CalcService calcService;
	
	@RequestMapping(method=RequestMethod.POST, value="/result/{id}")
	public String updateResult(@RequestBody String result, @PathVariable String id ) {
		calcService.addUser(id, result);
		return "Success!";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/result")
	public List<String> getAllResults(){
		return calcService.getAllResults();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/result/{id}")
	public String closeUser(@PathVariable String id ){
		calcService.deleteUserById(id);
		return "Success";
	}
}
