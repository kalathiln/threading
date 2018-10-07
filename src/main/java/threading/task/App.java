package threading.task;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Thread getTime = new GetTime();
        getTime.start();
        Runnable getMail = new GetMail(10);
        Runnable getTheMail = new GetMail(20);
        
        new Thread(getMail).start();
        new Thread(getTheMail).start();
        
    }
}
