/**
 * 
 */
package com.dredom.reactivex;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * How does the whole emitter thing work?
 * @author auntiedt, Feb 2020
 */
public class ObservableCreate {

	/**
	 * Creates an ObservableOnSubscribe "emitter".
	 * An Observer on this (see unit test) can consume every onNext value emitted.
	 * Useful, for example, where the consumer wanted to log progress being made on a task
	 * wrapped in an emitter. 
	 * @return {@link Observable}
	 */
	public Observable<String> create() {
		ObservableOnSubscribe<String> obs = new ObservableOnSubscribe<String>() {

			@Override
			public void subscribe(ObservableEmitter<String> emitter) throws Exception {
				System.out.println(" emitter init");
				emitter.onNext("emission 1");
				emitter.onNext("emission 2");
				emitter.onComplete();
			}
		};
		
		// Is this just a lambda version of ObservableOnSubscribe above?
		// Yes. Obervable.create takes an ObservableOnSubscribe.
		Observable<String> o = Observable.create(emitter -> {
			emitter.onNext(" emit #1");
			emitter.onNext(" emit #2");
			emitter.onComplete();
		});
//		return o;
		return Observable.create(obs);
	}
}
