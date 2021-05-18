package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {
	
	int num;
	
	ThreadedGreeter(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print("Hello from thread number: ");
		System.out.println(num);
		ThreadedGreeter tg = new ThreadedGreeter(num + 1);
		if (num < 50) {
			Thread joe = new Thread(() -> tg.run());
			joe.start();
			try {
				joe.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
