package com.ba.singleton;

public class LazySingleton {
	private static LazySingleton lazySingleton;
	
	private LazySingleton() {
		
	}
	
	public static LazySingleton getLazySingleton() {
		if(lazySingleton==null) {
			lazySingleton= new LazySingleton();
		
		}
		return lazySingleton;
	}
	
	public void singletonTest() {
		System.out.println("Lazy Singleton method calisti");
	}
	
	//Bu þekilde yaptýgýmýz zaman baþlangýçta bir instance yaratmaz ve bellekte yer kaplamaz. Fakat her çaðýrýldýgýnda null check yapmak zorunda kalýr. 
	//Birden fazla thread eriþmeye çalýþýrsa lag oluþturabilir veya runtime exception oluþturabilir. 
	//Multi thread iþlem yapmýyorsak en kolay ve en iyi yöntem olabilir.
	
}
