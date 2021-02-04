package com.ba.singleton;

public class ThreadSafeSingleton {
	
	private static ThreadSafeSingleton threadSafeSingleton;
	
	private ThreadSafeSingleton() {
		
	}
	
	public static synchronized ThreadSafeSingleton getThreadSafeSingleton() {
		if(threadSafeSingleton==null) {
			threadSafeSingleton=new ThreadSafeSingleton();
		}
		return threadSafeSingleton;
	}
	public void singletonTest() {
		System.out.println("ThreadSafe Singleton method calisti");
	}
	
	//Lazy singleton gibi çalýsýr fakat syncronized oldugu için iþlemleri sýraya kolay bu sayede multi thread çalýþmaya izin verir
	//Her seferinde bu check yaparken bir performans kaybý olur 
}
