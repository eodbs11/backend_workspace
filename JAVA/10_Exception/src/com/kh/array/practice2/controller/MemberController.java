package com.kh.array.practice2.controller;

import java.util.Arrays;

import com.kh.array.practice2.exception.DuplicateNameException;
import com.kh.array.practice2.exception.RecordNotFoundException;
import com.kh.array.practice2.model.Member;

public class MemberController {

	private Member[] mArr = new Member[3];
	public int count = 0;
	
	// 멤버 추가
	public void insertMember(Member m) throws DuplicateNameException, RecordNotFoundException {
		
		int index = checkId(m.getId());

		if(index==-1) {
			mArr[count++] = new Member(m.getId(), m.getName(), m.getPassword(), 
					m.getEmail(), m.getGender(), m.getAge());
		} else {
			// 회원이 기존에 있는 경우
			throw new DuplicateNameException();
		}
		
		
	}
	
	// 멤버 index를 아이디로 조회 --> 에러 발생 시키는 부분이 추가 / 수정!
	public int checkId(String id) throws DuplicateNameException, RecordNotFoundException {
		for(int i=0; i<mArr.length; i++) {
			if(mArr[i]!=null && mArr[i].getId().equals(id)) {
				throw new DuplicateNameException();
			} else {
				// throw new RecordNotFoundException();
			}
		}
		return -1;
	}
	
	public int checkUpdateId(String id) throws DuplicateNameException, RecordNotFoundException {
		for(int i=0; i<mArr.length; i++) {
			if(mArr[i]!=null && mArr[i].getId().equals(id)) {
				// throw new DuplicateNameException();
			} else {
				throw new RecordNotFoundException();
			}
		}
		return -1;
	}
	
	// 멤버 수정
	public void updateMember(String id, String name, String email, String password) 
			throws DuplicateNameException, RecordNotFoundException {
		int index = checkUpdateId(id);
		mArr[index].setName(name);
		mArr[index].setEmail(email);
		mArr[index].setPassword(password);
	}
	
	// 멤버 조회
	public Member[] printAll() {
		return mArr;
	}
}