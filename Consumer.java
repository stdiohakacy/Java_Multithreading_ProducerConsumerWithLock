package _06;

import java.util.List;

class Consumer implements Runnable {
	private List<Integer> taskQueue;

	public Consumer(List<Integer> sharedQueue) {
		this.taskQueue = sharedQueue;
	}

	private void consume() throws InterruptedException {
		synchronized (taskQueue) {
			while (taskQueue.isEmpty()) {
				Thread.sleep(200);
				System.out.println(
						"Queue is empty " + Thread.currentThread().getName() + " is waiting size" + taskQueue.size());
				taskQueue.wait();
			}
			Thread.sleep(200);
			int value = taskQueue.remove(0);
			System.out.println("Consumed " + value);
			taskQueue.notifyAll();
			
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				consume();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
