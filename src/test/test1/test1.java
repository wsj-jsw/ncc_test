package test.test1;

public class test1 {


    public static void main(String[] args) {

        ThreadData threadData = new ThreadData();
        RunnableDemo R1 = new RunnableDemo("Thread-1", "1",threadData);

        R1.start();

        RunnableDemo R2 = new RunnableDemo("Thread-2", "1",threadData);
        R2.start();
    }
}
