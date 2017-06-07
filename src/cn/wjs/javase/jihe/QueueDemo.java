package cn.wjs.javase.jihe;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);

		System.out.println(queue);
		queue.offer(4);
		queue.offer(5);
		queue.offer(6);
		System.out.println(queue);
		printQ(queue);
	}

	public static void printQ(Queue queue) {

		while (queue.peek() != null) { // peek()返回队列的头元素，如果队列为空则返回null

			System.out.print(queue.remove() + " ");// remove() 返回队列的头元素
			System.out.println("queue:" + queue);
		}
	}
}
