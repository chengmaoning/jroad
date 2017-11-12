/**
 * 
 */
package com.chengmaoning.jroad.java8feature;

import org.junit.Test;

/**
 * @author chengmaoning
 *
 */
public class DefaultMethodTest {

	interface Vehicle {
		default void print() {
			System.out.println("This is a vehicle.");
		}

		static void blowHorn() {
			System.out.println("Blow Horn.");
		}
	}

	interface FourWheeler {
		default void print() {
			System.out.println("This is a four wheeler.");
		}
	}

	class Car implements Vehicle, FourWheeler {
		@Override
		public void print() {
			Vehicle.super.print();
			FourWheeler.super.print();
			Vehicle.blowHorn();
			System.out.println("This is a car.");
		}
	}

	@Test
	public void test() {
		new DefaultMethodTest().new Car().print();
	}
}
