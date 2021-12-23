package part1;

public class Ex4Program {

	public static void main(String[] args) {
		Runnable sub = new Runnable() {
			@Override
			public void run() {
				print();
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
		
		Thread th = Thread.currentThread();
		th.setName("MAIN");
		print();
		 
		System.out.printf("%s : %s \n", th1.getName(), th1.getState());
		System.out.println("===================Main Exit ======================");
	}

	private static void print() { 
		Thread thread = Thread.currentThread();
		
//		System.out.printf("Thread ID : %d\n", thread.getId());
//		System.out.printf("Thread Name : %s\n", thread.getName());
//		System.out.printf("Thread Status : %s\n", thread.getState());
//		System.out.printf("Thread Priority : %d\n", thread.getPriority());
		
		for(int i=0 ; i < 100 ; i ++) {
		
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			System.out.printf("%s : %d \n", thread.getName(), i + 1);
		}
	}

}
