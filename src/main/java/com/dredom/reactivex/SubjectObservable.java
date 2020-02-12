/**
 * 
 */
package com.dredom.reactivex;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

/**
 * @author auntiedt
 *
 */
public class SubjectObservable {
	private String value = "none";
	
	private Subject<String> valueSubject;
	
	public Subject<String> getSubject() {
		if (valueSubject == null) {
			valueSubject = BehaviorSubject.createDefault(value);
		}
		return valueSubject;
	}
	
	public void setValue(String value) {
		this.value = value;
		valueSubject.onNext(value);
	}

}
