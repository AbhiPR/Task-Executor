CS 5348 
Operating Systems Concepts
Project 2

Task Executor Library

Name: Abhishek Palani Rajan
netid: axp154830

The project can be imported in any of the JAVA IDE and executed.

*Implemented a thread-safe Blocking FIFO in JAVA for multithreaded synchronization in order to maintain a pool of N threads that are used to execute 1000 tasks provided by "TaskExecutorTest.java".

*Designed a Blocking queue "BlockingQueueImpl.java" of size 100 using a circular array by using Synchronized blocks (without using JAVA's concurrent library) and executing the tasks provided in a thread safe manner.

*10 threads are created in "TaskExecutorImpl.java" which are directed towards the run() in "TaskRunner.java" where the function "execute()" which is method of "SimpleTestTask.java" is executed.

*This results in an output which consist of the name of the thread executing the task, name of the task getting executed and the number of executions occured.

  
