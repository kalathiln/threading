package threading.task;

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
        
    }
}
