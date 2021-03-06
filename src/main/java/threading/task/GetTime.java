package threading.task;
import java.text.DateFormat;

// Used for date and locale classes
import java.util.Date;
import java.util.Locale;

/**
 * This class implements the usage of thread.
 * Using threads we can run multiple blocks of code simultaneously.
 * 
 */
public class GetTime extends Thread{
	/*
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 * All the code that needs to be run inside a thread should be inside a method called run().
	 * This program will output the current time and date when the thread starts while not stopping,
	 *  or being stopped by other programs while it is being executed.
	 */
	public void run() {
		
		// Date and time details that needs to be stored.  
		Date rightNow;
		Locale currentLocale;
		DateFormat timeFormatter;
		DateFormat dateFormatter;
		String timeOutput;
		String dateOutput;
		
		for(int i=0; i<=10;i++) {
			// Stores the current date and the location			
			rightNow = new Date();
			// Locale India and the output to be in Hindi
			currentLocale = new Locale("hi","IN");
			
			timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);
			dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM, currentLocale);
			
			// Gathers the current date and time based on the format used above.
			timeOutput = timeFormatter.format(rightNow);
			dateOutput = dateFormatter.format(rightNow);
			
			// Prints the output
			System.out.println(timeOutput);
			System.out.println(currentLocale.toString());
			System.out.println(dateOutput);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
