package other;

import java.util.concurrent.Callable;

class CallableDemo implements Callable<Object> {
	private Thread t;
	private String threadName;
	
	CallableDemo(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				// Let the thread sleep for a while.
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(threadName);
			t.start();
		}
	}

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}