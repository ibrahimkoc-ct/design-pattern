package com.ba.observer;

import java.util.ArrayList;
import java.util.List;

public class Sms implements IMessageSystem{
	
	private List<Kullanici> kullanicilar= new ArrayList<Kullanici>();

	@Override
	public void addUser(Kullanici kullanici) {
        kullanicilar.add(kullanici);
		
	}

	@Override
	public void removeUser(Kullanici kullanici) {
        kullanicilar.remove(kullanici);
		
	}

	@Override
	public void sendMessage(String message) {
		kullanicilar.forEach(item->{
			item.mesajAl(message);
		});
		
	}

}
