/**
 * 
 */
package com.dredom.reactivex;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

/**
 * Emits whenever any of the observables is triggered.
 * @author auntiedt
 *
 */
public class ObservableCombineLatest {
	Subject<Boolean> obs1 = BehaviorSubject.createDefault(false);
	Subject<String> obs2 = BehaviorSubject.createDefault("none");
	
	public Observable<String> getCombineLatestObservable() {
		return Observable.combineLatest(obs1, obs2,  
				(o1, o2) -> "Obs1=" + o1 +", Obs2=" + o2 );
	}
	
	public void setValue1(boolean value1) {
		obs1.onNext(value1);
	}
	
	public void setValue2(String value2) {
		obs2.onNext(value2);
	}
}
