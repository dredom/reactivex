package com.dredom.reactivex;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObservableCreateTest {

	@Test
	public void create() throws Exception {
		ObservableCreate service = new ObservableCreate();
		
		Observable<String> obs = service.create();
		
		// Plain old subscribe. The Consumers for onNext, onError, onComplete 
		obs.subscribe(e -> System.out.println(e), 
				t ->  System.err.println("Failed " + t),
				() -> System.out.println("Done"));
		
		// Longhand way
		Observer<String> observer = new Observer<String>() {

			@Override
			public void onSubscribe(Disposable d) {
				System.out.println(" observer onSubscribe " );
			}

			@Override
			public void onNext(String t) {
				System.out.println(" observer onNext: " + t);
			}

			@Override
			public void onError(Throwable e) {
				System.out.println(" observer onError: " + e);
			}

			@Override
			public void onComplete() {
				System.out.println(" observer onComplete " );
			}
			
		};
		// Subscribe calling out the observer states.
		obs.subscribeWith(observer);
	}
}
