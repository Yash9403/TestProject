package Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableTask implements Callable<String>{
	
	private String name;
	
	public CallableTask(String name) {
		this.name = name;
	}
	
	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "Hello "+name;
	}
}

public class CallableRunner {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<String> welcome = executorService.submit(new CallableTask("Yash Patil"));
		System.out.println("new CallableTask(\"Yash Patil\")");
		String welcomemsg = welcome.get();
		System.out.println(welcomemsg);
		
		
		System.out.print("\n Main Completed");
	}
}
