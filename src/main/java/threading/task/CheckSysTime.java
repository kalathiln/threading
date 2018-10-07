package threading.task;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class CheckSysTime implements Runnable {
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run() All the code that needs to be run inside a thread
	 * should be inside a method called run(). This program will output the current
	 * time and date when the thread starts while not stopping, or being stopped by
	 * other programs while it is being executed.
	 */
	public void run() {
		// Date and time details that needs to be stored.
		Date rightNow;
		Locale currentLocale;
		DateFormat timeFormatter;
		String timeOutput;
		// Stores the current date and the location
		rightNow = new Date();
		// Locale India and the output to be in Hindi
		currentLocale = new Locale("hi", "IN");
		timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);
		// Gathers the current date and time based on the format used above.
		timeOutput = timeFormatter.format(rightNow);
		// Prints the output
		System.out.println(timeOutput);
	}

}
