package com.ba.singleton;


public class BillPughSingleton {
	private BillPughSingleton() {
		
	}
	
	public static final BillPughSingleton getInstance(){
		
		return SingletonHelper.INSTANCE;
		
	}
	
	private static class SingletonHelper{
		private static final BillPughSingleton INSTANCE= new BillPughSingleton();
		
		
		
	}
	public void singletonTest() {
		System.out.println("Bill Pugh Singleton method calisti");
	}
	
	//Yükleme süresi thread safe den kýsadýr. Direk olarak static bir degiþken tanýmlamadýgýmýz için jwm bunu hemen load etmeyecektir.
}
