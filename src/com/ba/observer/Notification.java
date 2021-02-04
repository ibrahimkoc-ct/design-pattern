package com.ba.observer;

import java.util.ArrayList;
import java.util.List;

public class Notification implements IMessageSystem{
	
	private List<IAbone> kullanicilar=new ArrayList<IAbone>();
	

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
