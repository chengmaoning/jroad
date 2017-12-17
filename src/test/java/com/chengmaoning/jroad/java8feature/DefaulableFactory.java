/**
 * 
 */
package com.chengmaoning.jroad.java8feature;

import java.util.function.Supplier;

import com.chengmaoning.jroad.java8feature.Defaulable.DefaultableImpl;
import com.chengmaoning.jroad.java8feature.Defaulable.OverridableImpl;

/**
 * @author chengmaoning
 *
 */
public interface DefaulableFactory {

	static Defaulable create(Supplier<Defaulable> supplier) {
		return supplier.get();
	}

	public static void main(String[] args) {
		Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
		System.out.println(defaulable.notRequired());

		defaulable = DefaulableFactory.create(OverridableImpl::new);
		System.out.println(defaulable.notRequired());
	}
}
