/**
 * 
 */
package com.chengmaoning.jroad.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.junit.After;
import org.junit.Test;

/**
 * MultiTheadTest.java
 * 
 * @author chengmaoning
 *
 *         2017年12月15日上午11:28:09
 */
public class MultiTheadTest {

	private ExecutorService pool = Executors.newCachedThreadPool();

	@After
	public void setUp() {
		pool.shutdown();
	}

	@Test
	public void testRunnable() {
		Thread thread = new Thread(() -> {
			System.out.println("hello world in runnable.");
		});
		thread.start();
		try {
			thread.join();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("exit.");

	}

	@Test
	public void testCallable() {
		Callable<String> callable = () -> "hello world in callable.";

		Future<String> future = pool.submit(callable);
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testFutureTask() {
		FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> 5);
		pool.submit(futureTask);
		try {
			System.out.println(futureTask.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
