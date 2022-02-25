package Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterServiceRunner {
	
	public static void main(String[] args) {
		
//		ExecutorService executerservice = Executors.newSingleThreadExecutor();
		
		ExecutorService executerservice = Executors.newFixedThreadPool(2);
		executerservice.execute(new Task(1));
		executerservice.execute(new Task(2));
		executerservice.execute(new Task(3));
		executerservice.execute(new Task(4));
		executerservice.execute(new Task(5));
		executerservice.execute(new Task(6));
		executerservice.execute(new Task(7));
		
		
		executerservice.shutdown();
	}

}
