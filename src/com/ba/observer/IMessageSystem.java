package com.ba.observer;

public interface IMessageSystem {
	
	 public void addUser(Kullanici kullanici);
	 public void removeUser(Kullanici kullanici);
	 public void sendMessage(String message);

}
