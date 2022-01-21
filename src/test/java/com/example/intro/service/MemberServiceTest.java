package com.example.intro.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.example.intro.domain.Member;
import com.example.intro.repository.MemoryMemberRepository;

public class MemberServiceTest {

	MemoryMemberRepository mmr = new MemoryMemberRepository();
	MemberService ms = new MemberService(mmr);
	/*
	 @BeforeEach
	public void beforeEach() {
		ms = new MemberService(mmr);
	}*/
	
	@AfterEach
	public void afterEach() { 
		mmr.clearStore();
	}
	
	@Test	
	// 회원가입
	void join() {
		// given
		Member member = new Member();
		member.setName("spring1");
		// when
		Long id = ms.join(member);		
		// then
		Member testMem = ms.findOne(id).get(); 
		Assertions.assertThat(member).isEqualTo(testMem);
	}

	@Test	
	// 중복 회원가입
	void dup_join() {
		// given
		Member member = new Member();
		member.setName("Spring1");
		Member member2 = new Member();
		member2.setName("Spring1");

		// when
		ms.join(member);		
		assertThrows(IllegalStateException.class,() -> ms.join(member2));
	}
	
}
