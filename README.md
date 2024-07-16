# MULTI-THREADING 

Multithreading is a programming concept where a single process is divided into multiple threads.
Each thread runs concurrently, sharing the same process resources but executing independently.
This allows for more efficient use of CPU resources and can improve the performance of an application,
particularly in scenarios involving I/O operations or tasks that can be executed in parallel.

### Key Features of Multithreading
* Concurrent Execution: Multiple threads can run concurrently within a single process.
* Shared Resources: Threads share the process's memory and resources, making communication between threads more efficient.
* Lightweight: Threads are lighter than processes as they require fewer resources to create and manage.
* Improved Performance: Multithreading can lead to better CPU utilization and responsiveness in applications, especially those with user interfaces or real-time requirements

### Process: 
* A process is an independent program in execution, containing its own memory space, data, and resources.
### Thread
* A thread is the smallest unit of execution within a process. It shares the process's resources and memory.

### Concurrency:
* Definition: Concurrency is the ability to execute multiple tasks or threads in overlapping time periods. It involves managing multiple tasks by switching between them, giving the illusion of simultaneous execution.
* Context Switching: Concurrency relies on context switching between tasks or threads, which can be managed by the operating system or language runtime.
* Use Case: Useful in scenarios where tasks involve waiting, such as I/O operations, allowing other tasks to execute while waiting.

### Parallelism:
* Definition: Parallelism is the ability to execute multiple tasks or threads simultaneously. It requires multiple processing units (e.g., multi-core processors) to truly execute tasks at the same time.
* Simultaneous Execution: Parallelism involves the actual simultaneous execution of tasks, without context switching.
* Use Case: Useful in scenarios where tasks can be divided into smaller subtasks that can be executed independently and simultaneously, such as numerical computations


In Java, there are several ways to create and manage threads. 
The primary methods to create threads are:

1. By Implementing the Runnable Interface:
2. By Extending the Thread Class:
3. By Implementing the Callable Interface and Using FutureTask:
4. Using the ExecutorService Framework:

### Using Runnable Interface:

* The Runnable interface is annotated with @FunctionalInterface, which means it has a single abstract method, run(). This allows instances of Runnable to be created using lambda expressions.
* `void run()`: This is the only method in the Runnable interface. When a thread is started, the JVM calls the run() method of the Runnable object that was passed to the thread's constructor.

### Implementing Runnable
#### To create a thread using the Runnable interface, you need to perform the following steps:
* Implement the Runnable interface.
* Provide an implementation of the run() method.
* Instantiate a Thread object, passing the Runnable instance to its constructor.
* Call the start() method on the Thread object.

### Code:

```
public class RunnableThread  {

    public static void main(String[] args) {

        Thread threadOne = new Thread(new Thread1());
        Thread threadTwo = new Thread(new Thread2());

        threadOne.start();
        threadTwo.start();
    }
}

class Thread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("From thread 1 "+ i);
        }
    }
}


class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("From thread 2 "+ i);
        }
    }
}

```
* Since Runnable is a functional interface, we can use lambda expressions to create instances of `Runnable`
### Code: 
```public class RunnableThread  {

    public static void main(String[] args) {

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("From thread 1 " + i);
            }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("From thread 2 " + i);
            }
        });

        threadOne.start();
        threadTwo.start();
    }
}

```

