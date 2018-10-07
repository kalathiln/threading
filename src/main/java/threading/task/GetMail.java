package threading.task;

public class GetMail implements Runnable{
	int startTime;
	
	

	public void run() {
		try {
			Thread.sleep(startTime*1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Checking Mail");
	}
	
	public GetMail(int startTime) {
		this.startTime = startTime;
		
	}
	
	
}
