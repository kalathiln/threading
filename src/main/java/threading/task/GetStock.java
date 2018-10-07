package threading.task;

/**
 * This class is to demonstrate the usage of runnable.
 * 
 * @author nikhil 
 * You can use the Runnable interface instead of extending the
 * thread class once. Gives more flexibility to the program compared to using Thread.
 */

public class GetStock implements Runnable {
	// Number of seconds before the execution of the thread.
	int startTime;

	/*
	 * All of the code that the thread executes must be in the run method, or be in
	 * a method called for from inside of the run method.
	 */
	public void run() {
		try {
			// Input will be taken as Seconds which is converted here to milliseconds.
			Thread.sleep(startTime * 1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Checking Stock Details");
	}

	// Constructor that sets the wait time for each new thread
	public GetStock(int startTime) {
		this.startTime = startTime;

	}

}
