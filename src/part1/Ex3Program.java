package part1;

public class Ex3Program {

	public static void main(String[] args) {
		Runnable sub = new Runnable() {
			@Override
			public void run() {
				print();
			}
		} ;
		
		Thread th1 = new Thread(sub);
		th1.setName("sub1");
		Thread th2 = new Thread(sub);
		th2.setName("sub2");
		
		th1.start();
		th2.start();
		
		Thread th = Thread.currentThread();
		th.setName("MAIN");
		print();
	}

	private static void print() {
		Thread thread = Thread.currentThread();
		
//		System.out.printf("Thread ID : %d\n", thread.getId());
//		System.out.printf("Thread Name : %s\n", thread.getName());
//		System.out.printf("Thread Status : %s\n", thread.getState());
//		System.out.printf("Thread Priority : %d\n", thread.getPriority());
		
		for(int i=0 ; i < 100 ; i ++) {
		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			System.out.printf("%s : %d \n", thread.getName(), i + 1);
		}
	}

}
