package com.example.intro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.example.intro.domain.Member;
import com.example.intro.repository.MemberRepository;

//@Service
@Transactional
public class MemberService {
	private final MemberRepository memberRepository;
	
	// Dependence Injection - 호출하는 외부에서 받아 넣어주며 생성하도록한다 -> 인스턴스 동기화를 위함
	public MemberService(MemberRepository memberRepostory) {  
		this.memberRepository = memberRepostory;
	}
	
	// 회원가입
	public Long join(Member member) {
		vaildateDuplicateMember(member); // 중복검증
		memberRepository.save(member);
		return member.getId();
	}
	// 중복체크
	private void vaildateDuplicateMember(Member member) {
		 memberRepository.findByName(member.getName()).ifPresent(m ->{
				throw new IllegalStateException("이미 존재하는 회원 입니다.");
			});
	}
	// 전체 회원조회
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	// 한 회원만 조회
	public Optional<Member> findOne(Long id){
		return memberRepository.findById(id);
	}
	
}
