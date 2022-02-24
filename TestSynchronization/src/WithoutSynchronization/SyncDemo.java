package WithoutSynchronization;

class Sender
{
	public synchronized void send(String msg)
	{
		System.out.println("Sending\t "+ msg);
		try {
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println("Thread interupted.");
		}
		System.out.println("\n "+msg+" Send");
	}
}

class ThreadSend extends Thread{
	
	private String msg;
	Sender sender;
	
	ThreadSend(String m, Sender obj)
	{
		msg = m;
		sender = obj;
	}
	
	public void run()
	{
		synchronized (sender) 
		{
			sender.send(msg);
		}
	}
}


public class SyncDemo 
{
	public static void main(String[] args) {
		Sender snd = new Sender();
		ThreadSend s1 = new ThreadSend(" Hi ",snd);
		
		ThreadSend s2 = new ThreadSend(" Bye ", snd);
		
		s1.start();
		s2.start();
		
		try {
			s1.join();
			s2.join();
		}
		catch(Exception e)
		{
			System.out.println("Interrupted");
		}
	}	
}
