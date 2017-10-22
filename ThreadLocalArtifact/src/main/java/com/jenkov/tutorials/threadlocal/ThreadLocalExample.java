package com.jenkov.tutorials.threadlocal;

public class ThreadLocalExample {
	public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

	// The InheritableThreadLocal class is a subclass of ThreadLocal. Instead of
	// each thread having its own value inside a ThreadLocal, the
	// InheritableThreadLocal grants access to values to a thread and all child
	// threads created by that thread.
	public static InheritableThreadLocal<Integer> inheritableThreadLocal = new InheritableThreadLocal<Integer>();

	public static class MyRunnable1 implements Runnable {

		public void run() {
			threadLocal.set((int) (Math.random() * 100D));
			inheritableThreadLocal.set((int) (Math.random() * 50));

			try {
				Thread.sleep(2000);				
			} catch (InterruptedException e) {
			}

			System.out.println(threadLocal.get());
		}
	}

	public static class MyRunnable2 implements Runnable {

		public void run() {
			threadLocal.set(500);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}

			System.out.println(threadLocal.get());

		}

	}

	public static void main(String[] args) throws InterruptedException {
		MyRunnable1 sharedRunnableInstance1 = new MyRunnable1();
		MyRunnable2 sharedRunnableInstance2 = new MyRunnable2();

		Thread thread1 = new Thread(sharedRunnableInstance1);
		Thread thread2 = new Thread(sharedRunnableInstance2);

		thread1.start();
		thread2.start();

		thread1.join(); // wait for thread 1 to terminate
		thread2.join(); // wait for thread 2 to terminate
	}

}