package other;

public class TestRunnable {

	public static void main(String args[]) {
		RunnableDemo R1 = new RunnableDemo("Thread-1");
		R1.start();
//		R1.getT().interrupt();
		RunnableDemo R2 = new RunnableDemo("Thread-2");
		R2.start();
//		R2.getT().interrupt();
		
		new RunnableDemo("Thread-3").start();
	}
}
