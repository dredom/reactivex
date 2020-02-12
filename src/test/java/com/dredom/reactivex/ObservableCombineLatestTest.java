package com.dredom.reactivex;

import static java.lang.System.out;

import org.junit.Test;

import io.reactivex.Observable;

public class ObservableCombineLatestTest {
	@Test
	public void basic() throws Exception {
		ObservableCombineLatest service = new ObservableCombineLatest();
		
		Observable<String> combineObservable = service.getCombineLatestObservable();
		
		combineObservable.subscribe(v -> out.println("CombineLatestObs=" + v));
		int n = 0;
		out.println(n++ + ". call val1");
		service.setValue1(true);
		out.println(n++ + ". call val2");
		service.setValue2("two");
		out.println(n++ + ". call val2");
		service.setValue2("three");
		out.println(n++ + ". call val2");
		service.setValue2("four");
		out.println(n++ + ". call val1");
		service.setValue1(false);
	}
}
