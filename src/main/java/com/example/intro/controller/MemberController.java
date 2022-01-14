package com.example.intro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.intro.service.MemberService;

@Controller
public class MemberController {
	
	private final MemberService ms; 

	@Autowired // 구동시 @service로 구동된 MemberService를 가져와 넣어준다
	public MemberController(MemberService ms) {
		this.ms = ms;
	}
}
