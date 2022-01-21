package com.example.intro.service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.intro.aop.TimeTraceAop;
import com.example.intro.repository.MemberRepository;


@Configuration
public class SpringConfig {
	
	/*
	// JdbcTemplate 연결
    private final DataSource dataSource;
     public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/
	/*
	// Jpa 연결
	private EntityManager em;
	public SpringConfig(EntityManager em) { this.em= em;}
	 */
	
	// SpringDataJpa 연결
    private final MemberRepository memberRepository;
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        //return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }
    
    
    
//    @Bean
//    public MemberRepository memberRepository() {
//        //return new MemoryMemberRepository();
//    	//return new JdbcMemberRepository(dataSource);
//    	//return new JdbcTemplateMemberRepository(dataSource);
//    	//return new JpaMemberRepository(em);
//    }
}
