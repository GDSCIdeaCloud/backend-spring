package com.example.demo;

import com.example.demo.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	public final MemberService memberService;
	@Autowired
	public DemoApplicationTests(MemberService memberService){
		this.memberService = memberService;
	}

	@Test
	void contextLoads() {
	}

}
