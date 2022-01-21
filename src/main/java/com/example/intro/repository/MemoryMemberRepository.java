package com.example.intro.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.intro.domain.Member;

//@Repository
public class MemoryMemberRepository implements MemberRepository{
	private static HashMap<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;
	
	
	@Override
	public Member save(Member member) { 
		member.setId(++sequence);
		store.put(member.getId(),member);
		return member;
	}
	
	@Override
	public Optional<Member> findById(Long id) {
		return 	Optional.ofNullable(store.get(id));  
	}

	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream()
			.filter(member -> member.getName().equals(name))
			.findAny(); // values를 stream객체로 반복문돌리듯 받아서, 객체의 이름이 찾는이름과 같은게 하나라도 있으면 반환
	}
	
	@Override
	public List<Member> findAll() {
		return new ArrayList<Member>(store.values());
	}
	
	public void clearStore() {
		store.clear();
	}
}
