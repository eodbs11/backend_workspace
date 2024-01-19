package com.kh.array.practice2.controller;

import java.util.Arrays;

import com.kh.array.practice2.model.Member;

public class MemberController {
	private Member [] mArr = new Member[3];
	public int count = 0;
	
	//회원 추가
	public void insertmember(Member m) {	
	  
		mArr[count++] = new Member(m.getId(), m.getName(), m.getPassword(),
									m.getEmail(), m.getGender(), m.getAge());
		System.out.println(Arrays.toString(mArr)); // 임시확인
				
	}	
	
	//회원의 index를 아이디로 조회
	
	public int checkId(String id) {
		for(int i = 0; i<mArr.length; i++) {
			if(mArr[i]!=null && mArr[i].getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	//회원 정보 수정
	public void updatemember(String id, String name, String email, String password) {	
		  int index = checkId(id);
		  mArr[index].setName(name);
		  mArr[index].setEmail(email);
		  mArr[index].setPassword(password);		
				
	}	
	// 회원 조회
	public Member[] printAll() {
		return mArr;
	}
}
