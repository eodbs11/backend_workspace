package com.kh._interface.step2;

public class Audio implements RemoteControl, Searchable{

	private int volume;
	
	@Override
	public void setVolume(int volume) {
		
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 Audio 볼륨 : " + this.volume);
	}

	@Override
	public void search(String url) {
		System.out.println(url + "을 연결 합니다.");
	}

	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
	}

}
