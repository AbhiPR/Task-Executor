package com.project.taskexecutor;

import java.util.Random;

public class BlockingTaskQueue {

	public static Task[] bQueue = new Task[100];
	public static int front = -1;
	public static int rear = -1;
	public static int p = 0;
	static Object lock1 = new Object();
//static Object lock2 = new Object();
	static Random rnd = new Random();

	public static boolean isEmpty() {

		return (front == -1 && rear == -1);
	}

	public static boolean isFull() {
		return ((rear + 1) % 100 == front);
	}

	public static void add(Task i) {
		synchronized (lock1) {
			while (isFull()) {
				try {
					lock1.wait();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		} // } catch (InterruptedException e) {}}
		synchronized (lock1) {

			if (isEmpty()) {
				front = 0;
				rear = 0;
				bQueue[rear] = i;
			} else {
				rear = (rear + 1) % 100;
				bQueue[rear] = i;

			}
			lock1.notify();

		}

	}

	public static Task remove() {

		synchronized (lock1) {
			while (isEmpty()) {
				try {
					lock1.wait();
				} catch (InterruptedException e) {
				}
			}
		}

		Task ele;
		synchronized (lock1) {
			if (p <= rnd.nextInt(30)) {
				p = 0;
				lock1.notify();
			}
			ele = bQueue[front];

			if (front == rear) {
				front = -1;
				rear = -1;
				lock1.notify();

			} else
				front = (front + 1) % 100;
			p++;

		}
		return ele;
	}

}
