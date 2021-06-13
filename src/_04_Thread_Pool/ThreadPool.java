package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	
	int threadCount;
	Thread[] threads;
	ConcurrentLinkedQueue<Task> taskQueue;
	ThreadPool(int count) {
		this.threadCount = count;
		
		taskQueue = new ConcurrentLinkedQueue<Task>();
		
		threads = new Thread[count];
		for (int i = 0; i < count; i++) {
			threads[i] = new Thread(new Worker(taskQueue));
		}
	}

	public void start() {
		// TODO Auto-generated method stub
		for (Thread t : threads) {
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void addTask(Task object) {
		// TODO Auto-generated method stub
		taskQueue.add(object);
		
	}
}
