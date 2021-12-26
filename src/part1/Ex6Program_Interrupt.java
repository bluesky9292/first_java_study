package part1;

public class Ex6Program_Interrupt {

	public static void main(String[] args) {
		Thread th = Thread.currentThread();
		th.setName("MAIN");

		Runnable sub = new Runnable() {
			@Override
			public void run() {
				System.out.printf("-------%s : %s \n", th.getName(), th.getState());
				print();
				System.out.printf("----------%s : %s \n", th.getName(), th.getState());
			}
		} ;
		
		Thread th1 = new Thread(sub);
		th1.setName("sub1");
		System.out.printf("%s : %s \n", th1.getName(), th1.getState());
		
		th1.start();
		System.out.printf("%s : %s \n", th1.getName(), th1.getState());
		System.out.printf("%s : %s \n", th1.getName(), th1.getState());
		System.out.printf("%s : %s \n", th1.getName(), th1.getState());
		System.out.printf("%s : %s \n", th1.getName(), th1.getState());
		System.out.printf("%s : %s \n", th1.getName(), th1.getState());
		
//		print();
		 
		if (th1.isAlive()) {
			try {
				th1.join(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			th1.interrupt();
		}
		System.out.printf("%s : %s \n", th1.getName(), th1.getState());
		System.out.println("===================Main Exit ======================");
	}   

	private static void print() { 
		Thread thread = Thread.currentThread();
		
//		System.out.printf("Thread ID : %d\n", thread.getId());
//		System.out.printf("Thread Name : %s\n", thread.getName());
//		System.out.printf("Thread Status : %s\n", thread.getState());
//		System.out.printf("Thread Priority : %d\n", thread.getPriority());
		
		for(int i=0 ; i < 10000 ; i ++) {
		
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if ( thread.isInterrupted())
				
		
			System.out.printf("%s : %d \n", thread.getName(), i + 1);
		}
	}

}
