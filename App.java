package _06;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		List<Integer> queue = new ArrayList<Integer>();
		int MAX_CAPACITY = 5;
		
		Thread producerThread = new Thread(new Producer(queue, MAX_CAPACITY));
		producerThread.start();
		
		Thread consumerThread = new Thread(new Consumer(queue));
		consumerThread.start();
	}
}