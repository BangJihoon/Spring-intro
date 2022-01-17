package com.example.intro.service;


import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;

import com.example.intro.repository.JdbcMemberRepository;
import com.example.intro.repository.MemberRepository;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
    	return new JdbcMemberRepository(dataSource);
    	//return new JdbcTemplateMemberRepository(dataSource);
	}
}
