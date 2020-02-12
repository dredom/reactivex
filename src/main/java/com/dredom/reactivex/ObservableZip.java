/**
 * 
 */
package com.dredom.reactivex;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

/**
 * Single Observable representing multiple observables.
 * Waits for an emit from each of the zipped observables before emitting a zip observable.
 * 
 * @author auntiedt
 *
 */
public class ObservableZip {

	Subject<Boolean> obs1 = BehaviorSubject.createDefault(false);
	Subject<String> obs2 = BehaviorSubject.createDefault("none");
	
	public Observable<String> getZipObservable() {
		return Observable.zip(obs1, obs2,  
				(o1, o2) -> "Obs1=" + o1 +", Obs2=" + o2 );
	}
	
	public void setValue1(boolean value1) {
		obs1.onNext(value1);
	}
	
	public void setValue2(String value2) {
		obs2.onNext(value2);
	}
}
