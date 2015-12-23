package com.project.taskexecutor;

public class TaskRunner implements Runnable {

	public BlockingTaskQueue q;

	public void run() {
		while (true) {

			Task newTask = null;

			newTask = BlockingTaskQueue.remove();

			try {

				newTask.execute();
			} catch (Throwable th) {
			}

		}

	}
}
