package com.example.intro.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.example.intro.domain.Member;

public class MemoryMemberRepositoryTest {
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach
	public void afterEach() { 
		repository.clearStore();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("Spring"); 
		repository.save(member);
		
		Member result = repository.findById(member.getId()).get();		
		Assertions.assertThat(member).isEqualTo(result);
	}	
	@Test
	public void findByName() {
		Member member = new Member();
		member.setName("Spring");
		repository.save(member);
		
		Member result = repository.findByName("Spring").get();
		Assertions.assertThat(member).isEqualTo(result);
	}
	
	@Test
	public void findAll() {
		Member member = new Member();
		member.setName("Spring1");
		repository.save(member);
		Member member2 = new Member();
		member2.setName("Spring2");
		repository.save(member2);
		
		List<Member> result= repository.findAll();
		Assertions.assertThat(result.size()).isEqualTo(2);

	}
	
	
}
