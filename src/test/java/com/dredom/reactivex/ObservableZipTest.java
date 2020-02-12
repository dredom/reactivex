package com.dredom.reactivex;

import static java.lang.System.out;

import org.junit.Test;

import io.reactivex.Observable;

public class ObservableZipTest {

	@Test
	public void basic() throws Exception {
		ObservableZip service = new ObservableZip();
		
		Observable<String> zipObservable = service.getZipObservable();
		
		zipObservable.subscribe(v -> out.println("ZipObs=" + v));
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
