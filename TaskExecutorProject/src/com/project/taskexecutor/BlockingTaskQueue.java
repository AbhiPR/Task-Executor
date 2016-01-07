package com.project.taskexecutor;

public class BlockingTaskQueue {

	public Task[] bQueue;
	public int front;
	public int rear;
	public int num;
	public int capacity;

	Object full;
	Object empty;

	public BlockingTaskQueue() {
		bQueue = new Task[100];
		num = 1;
		front = -1;
		rear = -1;
		full = new Object();
		empty = new Object();
	}

	public boolean isEmpty() {

		return (front == -1 && rear == -1);
	}

	public boolean isFull() {
		return ((rear + 1) % 100 == front);
	}

	public void add(Task i) {

		if (isFull()) {
			synchronized (full) {
				try {
					full.wait();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		}
		synchronized (this) {

			if (isEmpty()) {
				front = 0;
				rear = 0;
			} else
				rear = (rear + 1) % 100;

			bQueue[rear] = i;

			synchronized (empty) {
				if (isFull())
					empty.notify();
			}

		}

	}

	public Task remove() {

		if (isEmpty()) {
			synchronized (empty) {
				try {
					empty.wait();
				} catch (InterruptedException e) {
				}
			}
		}
		synchronized (this) {

			Task ele;

			ele = bQueue[front];
			if (front == rear)
				front = rear = -1;
			else
				front = (front + 1) % 100;

			synchronized (full) {
				full.notify();
			}
			return ele;

		}
	}
}
