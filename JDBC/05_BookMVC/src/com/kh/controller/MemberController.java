package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class MemberController {

	private MemberDAO dao = new MemberDAO();

	public boolean registerMember(String id, String password, String name) {
		try {
			if (dao.registerMember(id, password, name) == 1) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Member login(String id, String password) {
		Member member;
		try {
			member = dao.login(id, password);
			if(member.getStatus().equals("Y")) return member;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 4. 회원탈퇴
	public boolean deleteMember(int no){
		try {
			if(dao.deleteMember(no)==1) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}