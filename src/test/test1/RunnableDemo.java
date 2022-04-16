package test.test1;

public class RunnableDemo implements Runnable {
    private Thread t;
    private ThreadData threadData;
    private String threadName;
    private String threadKey;

    RunnableDemo(String name, String key, ThreadData data) {
        threadName = name;
        threadKey = key;
        threadData = data;
        System.out.println("Creating " + threadName);
    }

    public ThreadData getThreadData() {
        return threadData;
    }

    public void setThreadData(ThreadData threadData) {
        this.threadData = threadData;
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {

            System.out.println( "Thread: " + threadName + ", "+  threadData.processCachedData(threadKey));

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
