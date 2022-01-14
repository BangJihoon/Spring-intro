package com.example.intro.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.intro.repository.MemberRepository;
import com.example.intro.repository.MemoryMemberRepository;

@Configuration
public class SpringConfig {
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}
