package com.kh.test4;


import com.kh.test4.model.Person;

public class Application {	
	
	public static void main(String[] args) {

		
		Person[] pArr = new Person[3];				
		
		for(int i=0; i <= pArr.length; i++) {
			pArr[i]= new Person();
		}
		System.out.println();	
		
	}

}
