package com.project.taskexecutor;

public class TaskExecutorImpl{

	BlockingTaskQueue obj;

	    TaskExecutorImpl(int size) {
        obj= new BlockingTaskQueue();
		TaskRunner s=new TaskRunner(obj);
		for (int j = 0; j < size; j++) {
			
			Thread t=new Thread(s);
			t.start();
		}
	}

	public void addTask(Task task) {
		
			obj.add(task);
		
	}
}
