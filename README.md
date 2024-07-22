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

## Implementing Runnable Interface
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

## Extending the `Thread` Class for Multithreading

* One way to create a new thread in Java is by extending the Thread class. This involves creating a subclass of Thread and overriding its run() method with the code you want the new thread to execute.

#### Key Points:
* Simplicity: This method is straightforward and easy to understand for beginners.
* Less Flexible: Extending Thread can be less flexible compared to implementing Runnable because Java does not support multiple inheritance. If your class already extends another class, you cannot extend Thread.
* Thread Safety: Ensure that the code in the run() method is thread-safe if it accesses shared resources.

## Code:
```java

public class ExtendsThread {

    public static void main(String[] args) {
        Thread one  = new Thread1();
        Thread two = new Thread2();
        one.start();
        two.start();
    }
}

class Thread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("From thread 1: " + i);
        }
    }
}
class Thread2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("From thread 2: " + i);
        }
    }
}
```

### Comparision between `Runnable` Interface and `Thread` Class 

### Performance
* Runnable: Generally has a slight edge in performance due to the ability to separate task logic from thread management. This can lead to better optimization and resource management.
* Thread: Slightly less performant if many thread objects are created due to the additional overhead of inheriting the Thread class.
### Flexibility
* Runnable: More flexible as it allows a class to implement multiple interfaces. This is useful if your class needs to extend another class.
* Thread: Less flexible due to Java's single inheritance model. If you extend Thread, you cannot extend any other class.
### Safety
* Runnable: Encourages better design by promoting separation of concerns. The task is separated from the thread's execution mechanics, making the code easier to manage and test.
Thread: Tends to encourage a tighter coupling between the task and the thread's execution mechanics, which can lead to design issues and harder-to-maintain code.
### Code Reusability
* Runnable: Promotes code reusability. The same Runnable instance can be passed to multiple Thread objects.
* Thread: Less reusable as each subclass of Thread is typically tied to a specific task.
### Use Case
* Runnable: Ideal for scenarios where tasks can be separated from the thread execution or when the class needs to extend another class.
* Thread: Suitable for simple applications where extending a single class to create a new thread is sufficient.
### Summary
* Performance: Runnable has a slight edge.
* Flexibility: Runnable is more flexible.
* Safety: Runnable encourages better design and separation of concerns.
* Code Reusability: Runnable is more reusable.
* Use Case: Runnable is generally preferred, especially for more complex designs.

### `Join` method in Java Threads

```java
public class Main {

    public static void main(String[] args) {

        Thread one  = new Thread(() -> runLoop("Thread 1"));
        Thread two  = new Thread(() -> runLoop("Thread 2"));
        
        System.out.println("Before starting threads");
        
        one.start();
        two.start();
        
        System.out.println("Done executing threads");

    }

    private static void runLoop(String thread){
        for (int i = 0; i < 10; i++) {
            System.out.println("From " + thread + " " + i);
        }
    }
}
```
* When the above code gets executed the first thing that will be printed is: <br>
`Before starting threads`<br>
`Done executing threads`

- This is because the `Main` Thread is executed first and has the highest priority.
Then,  the Thread one and two are executed independently based on availability of resources.

Now, if we want `Done executing threads` to be printed only after thread 1, 2 is executed, then we can use the `Join` Method

* The join method in Java is used to pause the execution of the current thread
until the thread on which join was called has finished executing.
This is particularly useful when you want one thread to wait for another to
complete before continuing its own execution.
* Parent thread waits for the completion of the child thread and then continues its execution.
```java
public class JoinThread {

    public static void main(String[] args) throws InterruptedException {

        Thread one  = new Thread(() -> runLoop("Thread 1"));
        Thread two  = new Thread(() -> runLoop("Thread 2"));
        
        System.out.println("Before starting threads");
        
        one.start();
        two.start();
        one.join();
        two.join();
        
        System.out.println("Done executing threads");
    }

    private static void runLoop(String thread){
        for (int i = 0; i < 10; i++) {
            System.out.println("From " + thread + " " + i);
        }
    }
}
```

### Race Condition:
A race condition occurs in a multi-threaded environment when two or more
threads access shared data and try to change it simultaneously.
Without proper synchronization, the final outcome of the operations depends on the
timing of the threads, leading to unpredictable and incorrect results.

#### Example:
```java
public class RaceCondition {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread one = new Thread(RaceCondition::runLoop);
        Thread two = new Thread(RaceCondition::runLoop);

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println(counter);
    }

    private static void runLoop(){
        for (int i = 0; i < 10000; i++) {
            counter++;
        }
    }
}
```
* The final outcome of counter value is always unpredictable, This is because both the 
threads are accessing the same variable simultaneously.
* Essentially what `counter++` does is : It loads counter value in memory, increment it by one and hen assign it back to counter variable
    * Loads Counter in memory with value 0 
    * Increment the value of counter to  counter + 1
    * Assign the value back to counter variable
* During this process both threads might update the value at the same time. 

### Avoiding Race Condition:

#### Using `Synchronized` keyword
* The synchronized keyword in Java is used to control access to a shared
resource by multiple threads. It ensures that only one thread can execute
a block of code or a method that is marked as synchronized at any given time,
thereby preventing race conditions and ensuring thread safety.

```java
private synchronized static void runLoop(){
        for (int i = 0; i < 10000; i++) {
            counter++;
        }
    }
```
If we add the `synchronized` keyword to the block, this is always going to ensure that only one thread
will access it.
##### How synchronized Works:
When a thread enters a synchronized block or method,
it acquires a lock (or monitor) associated with the object or class.
Other threads attempting to enter a synchronized block or method on the same object
or class will be blocked until the lock is released by the thread currently holding it.

#### Best Practices:
* Minimize Synchronized Blocks: Keep synchronized blocks as short as possible to reduce contention and improve performance.
* Avoid Synchronizing on this or Other Public Objects: This can lead to unexpected deadlocks or other synchronization issues if other code synchronizes on the same object.
* Prefer Concurrent Collections: Use classes from java.util.concurrent package, such as ConcurrentHashMap, which provide better performance and scalability for concurrent access.
