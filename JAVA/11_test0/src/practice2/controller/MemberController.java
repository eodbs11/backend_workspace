package practice2.controller;

import java.util.Arrays;

import practice2.exception.DuplicateNameException;
import practice2.exception.RecordNotFoundException;
import practice2.model.Member;

public class MemberController {
	private Member[] mArr = new Member[3];
	public int count = 0;

	// 회원 추가
	public void insertmember(Member m) throws DuplicateNameException, RecordNotFoundException {

		int index = checkId(m.getId());
		if (index == 1) {
			mArr[count++] = new Member(m.getId(), m.getName(), m.getPassword(), m.getEmail(), m.getGender(),
					m.getAge());
		} else {
			// 회원이 기존에 있는 경우
			throw new DuplicateNameException();
		}

	}

	// 회원의 index를 아이디로 조회 --> 에러 발생 시키는 부분이 추가 / 수정!

	public int checkId(String id) throws DuplicateNameException {
		for (int i = 0; i < mArr.length; i++) {
			if (mArr[i] != null && mArr[i].getId().equals(id)) {
				throw new DuplicateNameException();
			} else {
//				throw new RecordNotFoundException();
			}
		}
		return -1;
	}

	public int checkUpdateId(String id) throws RecordNotFoundException {
		for (int i = 0; i < mArr.length; i++) {
			if (mArr[i] != null && mArr[i].getId().equals(id)) {
//				throw new DuplicateNameException();				
			} else {
				throw new RecordNotFoundException();
			}
		}
		return -1;
	}

	// 회원 정보 수정
	public void updatemember(String id, String name, String email, String password)
			throws DuplicateNameException, RecordNotFoundException {
		int index = checkUpdateId(id);
		mArr[index].setName(name);
		mArr[index].setEmail(email);
		mArr[index].setPassword(password);

	}

	// 회원 조회
	public Member[] printAll() {
		return mArr;
	}
}
