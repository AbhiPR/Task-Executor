package com.project.taskexecutor;

public class TaskRunner implements Runnable {

	BlockingTaskQueue queue;

	public TaskRunner(BlockingTaskQueue o) {
		queue = o;
	}

	public void run() {
		while (true) {

			Task newTask = null;

			newTask = queue.remove();

			try {

				newTask.execute();
			} catch (Throwable th) {
			}

		}

	}
}
