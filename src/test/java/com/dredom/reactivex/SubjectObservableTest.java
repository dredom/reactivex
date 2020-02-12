package com.dredom.reactivex;

import org.junit.Test;

import io.reactivex.Observable;

public class SubjectObservableTest {

	@Test
	public void basic() throws Exception {
		SubjectObservable service = new SubjectObservable();
		Observable<String> obs = service.getSubject();
		
		obs.subscribe( value -> System.out.println(value));
		
		service.setValue("one");
		service.setValue("two");
		
	}
	
}
