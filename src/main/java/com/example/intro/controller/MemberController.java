package com.example.intro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.intro.domain.Member;
import com.example.intro.service.MemberService;

@Controller
public class MemberController {
	
	private final MemberService memberService; 

	@Autowired // 구동시 @service로 구동된 MemberService를 가져와 넣어준다
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/members/new") // url 접근시 members/createMemberForm 페이지 
	public String createForm() {
		return "members/createMemberForm";
	}
	
	@PostMapping("/members/new")
	public String create(MemberForm form) {
		Member member = new Member();
		member.setName(form.getName());
		
		memberService.join(member);
		
		return  "redirect:/"; 
	}
	
	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		// List를  "members/memberList" body에서 members 속성에 반환
		model.addAttribute("members",members);
		return "members/memberList";
	}
	
}
