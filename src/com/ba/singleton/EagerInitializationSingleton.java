package com.ba.singleton;

public class EagerInitializationSingleton {
	
	private static final EagerInitializationSingleton INSTANCE = new EagerInitializationSingleton();
	
	private EagerInitializationSingleton() {
		
	}
	
	public static EagerInitializationSingleton getInstance() {
		return INSTANCE;
	}
	public void singletonTest() {
		System.out.println("Eager Singleton method calisti");
	}
	
	//Bu durum bize bir tane instance yaratmayý garanti eder fakat ihtiyacýmýz olmadýgý durumlarda bile program çalýþtýgý an bellekte yer kaplayacaktýr
	// ve exception handling yok
}
