package part1;

public class Ex8Program_ThreadGroup {

	public static void main(String[] args) {
		Runnable sub = new Runnable() {
			@Override
			public void run() {
				print();
			}
		} ;
		
		ThreadGroup threadGroup = new ThreadGroup("Print Main Group");
		ThreadGroup threadGroup1 = new ThreadGroup(threadGroup, "Print Sub Group1");
		ThreadGroup threadGroup2 = new ThreadGroup(threadGroup, "Print Sub Group2");
		
		Thread th1 = new Thread(threadGroup1, sub);
		th1.setName("sub1");
		Thread th2 = new Thread(threadGroup1, sub);
		th2.setName("sub2");
		th2.setPriority(Thread.MAX_PRIORITY);
		Thread th3 = new Thread(threadGroup1, sub);
		th3.setName("sub3");
		Thread th4 = new Thread(threadGroup2, sub);
		th4.setName("sub4");
		Thread th5 = new Thread(threadGroup2, sub);
		th5.setName("sub5");
		Thread th6 = new Thread(threadGroup2, sub);
		th6.setName("sub6");
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
		th6.start();
		
		Thread th = Thread.currentThread();
		th.setName("MAIN");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//print();
		threadGroup.list();
		threadGroup.interrupt(); 
		System.out.println("---------------Main Exit -----------------------");
	}

	private static void print() {
		Thread thread = Thread.currentThread();
		
//		System.out.printf("Thread ID : %d\n", thread.getId());
//		System.out.printf("Thread Name : %s\n", thread.getName());
//		System.out.printf("Thread Status : %s\n", thread.getState());
//		System.out.printf("Thread Priority : %d\n", thread.getPriority());
		
		for(int i=0 ; i < 100 ; i ++) {
			if ( thread.isInterrupted()) {
				System.err.printf("%s요청이 들어와서 종료 함 \n",thread.getName());
				return ;
			}
		
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.err.printf("%s 자다가 깨서 종료 함 \n",thread.getName());
				return ;
			}
		
			System.out.printf("%s : %d \n", thread.getName(), i + 1);
		}
	}

}
