package com.example.intro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data", " 컨트롤러에서 데이터 전달"); 
		return "hello"; 
	}
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam(value = "name", required = false, defaultValue = "Empty") String name , Model model) {
		model.addAttribute("name", name);
		return "hello-template";
	}	
	
	@GetMapping("hello-api-data")
	@ResponseBody
	public Person helloApi(@RequestParam(value = "data", required = false, defaultValue = "Empty") String data) {
		Person person = new Person();
		person.setName(data);
		return person;
	}
	static class Person{ //alt + shift + s -> r
		private String name;

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
}
	
