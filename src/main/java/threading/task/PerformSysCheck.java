package threading.task;
/*
 * Used in order to lock a resource or a method in case they are being accessed
 * at the same time. 
 */
import java.util.concurrent.locks.ReentrantLock;

public class PerformSysCheck implements Runnable{
	
	private String checkRes;
	
	ReentrantLock lock = new ReentrantLock();
	public PerformSysCheck(String checkRes) {
		this.checkRes = checkRes;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * whenever we use synchronized before a method,
	 * synchronized public void run() {
	 * it makes sure that whenever this piece of code is executed or is being called,
	 * there is a lock which holds this resource, without letting any other piece of code to 
	 * modify or access it.
	 * But. it will make the Java program pretty slow.
	 */
	public void run() {
		lock.lock();
		System.out.println("Checking "+checkRes);
		lock.unlock();
	}
	
}
