package src.com.kh.controller;

import src.com.kh.controller.component.RegisterController;

// Controller의 공장 역할
public class HandlerMapping {
	// 싱글톤 패턴 - 특정 클래스의 객체가 오직 한 개만 존재하도록 하기 위해서
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {
		public static HandlerMapping getInstance() {
			return handler;
		}
	}
	
	// controller 생성!
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("register.do")) {
			controller = new RegisterController();
		}
		
		return controller;
	}
	
}
