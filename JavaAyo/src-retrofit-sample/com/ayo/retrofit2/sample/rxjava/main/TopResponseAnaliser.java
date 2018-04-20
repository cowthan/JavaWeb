package com.ayo.retrofit2.sample.rxjava.main;

import rx.functions.Func1;

public class TopResponseAnaliser<T extends TopResponse<X>, X> implements Func1<T, X>{

	@Override
	public X call(T t) {
		System.out.println("处理BaseHttpCallback");
		return t.body();
	}
	
	
}
