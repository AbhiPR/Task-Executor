package com.project.taskexecutor;

public class TaskExecutorImpl {

	int threads;

	TaskExecutorImpl(int size) {

		TaskRunner s = new TaskRunner();
		for (int j = 0; j < size; j++) {
			Thread t = new Thread(s);
			t.start();
		}
	}

	public void addTask(Task task) {

		BlockingTaskQueue.add(task);

	}
}
