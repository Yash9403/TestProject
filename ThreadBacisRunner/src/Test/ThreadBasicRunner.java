package Test;

class Task extends Thread{
	
	private int number;
	
	public Task(int number) {
		this.number=number;
	}
	
	public void run() {
		System.out.println("Task "+number+" started");
		for(int i=number*100;i<=number*100+99;i++){
			System.out.print(i+" ");
		} 
		System.out.println("Task "+number+" is done");
	}
}

class Task2 implements Runnable{
	public void run() {
		System.out.println("Task 2 started");
		for(int i=201;i<=299;i++){
			System.out.print(i+" ");
		}
		System.out.println("Task 2 is done");
	}
}


public class ThreadBasicRunner {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Task1 is kicked off");
//		Task1 t1 = new Task1();
//		t1.start();
//		
		
		System.out.println("Task 2 is kicked off");
		Task2 t2 = new Task2();
		Thread task2thread = new Thread(t2);
		task2thread.setPriority(10);
		task2thread.start();
		
//		t1.join();
		task2thread.join();
		System.out.println("Task 3 is kicked off");
		//Task3
		for(int i=301;i<=399;i++)
		{
			System.out.print(i+" ");
			
		}
		System.out.println("Task 3 is done");
		
		System.out.println("Main is done");
		
	}

}
