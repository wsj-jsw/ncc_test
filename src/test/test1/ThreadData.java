package test.test1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadData {

    private static Map<String, Object> cacheData = new HashMap<String, Object>();//构造缓存对象
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();//构造读写锁
    public Object processCachedData(String key) {
        Object value = null;
        try {
            rwl.readLock().lock();
            System.out.println(Thread.currentThread().getName()+"正在get");
            value = cacheData.get(key);
            if (value == null) {
                try {
                    rwl.readLock().unlock();
                    rwl.writeLock().lock();
                    // 再次判断该值是否为空，因防止两个线程同时写入
                    if (value == null) {
                        value = "value1";
                        System.out.println(Thread.currentThread().getName()+"正在set");
                        cacheData.put(key, value);
                    }
                    rwl.readLock().lock();
                } finally {
                    rwl.writeLock().unlock();
                }
            }
        } finally {
            rwl.readLock().unlock();
        }
        return value;
    }

    public static void main(String[] args) {

    }


}


