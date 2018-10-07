package threading.task;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Threading output using the Thread class and the Runnable Interface
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// Create a new Thread that executes the code in GetTime
        Thread getTime = new GetTime();
        getTime.start();
        // Create a new Thread created using the Runnable interface
        // First with a 10 second delay and then with a 20 second.
        Runnable getStock= new GetStock(10);
        Runnable getStockAgain = new GetStock(20);
        // Calls the thread to start, which runs the code inside the run method of GetStock
        new Thread(getStock).start();
        new Thread(getStockAgain).start();
        // Threading based on Thread pools
        addThreadToPool();
        
    }

	private static void addThreadToPool() {
		
		/* Allows to schedule code execution at some time in the future.
		 * It must be big enough to hold all potential Threads
		*/
		ScheduledThreadPoolExecutor eventPool = new ScheduledThreadPoolExecutor(5);
		/* Adds a Thread to the pool. Tells that thread to start executing
		 * Takes in arguments such as a Command(method) which needs to be run,
		 * The time it should start executing the particular command once the program has started.
		 * And after how long should it keep executing.
		 */
		eventPool.scheduleAtFixedRate(new CheckSysTime(), 0, 2, TimeUnit.SECONDS);
		eventPool.scheduleAtFixedRate(new PerformSysCheck("CPU Cores"), 2, 10, TimeUnit.SECONDS);
		eventPool.scheduleAtFixedRate(new PerformSysCheck("RAM Usage"), 5, 15, TimeUnit.SECONDS);
		System.out.println("No Of Active Threads :"+Thread.activeCount());
		
		Thread[] listOfThreads = new Thread[Thread.activeCount()];
		Thread.enumerate(listOfThreads);
		
		for(Thread i:listOfThreads) {
			// To get the name of the thread
			System.out.println(i.getName());
			// To get the priority of the thread (1 is lowest and 10 is highest priority)
			System.out.println(i.getPriority());
		}
		eventPool.shutdown();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
}
