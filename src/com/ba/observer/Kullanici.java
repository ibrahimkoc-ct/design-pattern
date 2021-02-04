package com.ba.observer;

public class Kullanici implements IAbone{

	@Override
	public void mesajAl(String message) {
		 System.out.println(message);
		
	}

}
