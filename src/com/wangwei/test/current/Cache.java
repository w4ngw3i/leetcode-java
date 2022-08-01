package com.wangwei.test.current;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wangwei
 * @version 1.0
 * @date 2021-09-13 17:39
 */
public class Cache<K, V> {
    final Map<K, V> map = new HashMap<>();
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    final Lock readLock = rwl.readLock();
    final Lock writeLock = rwl.writeLock();

    public  V get(K key) {
        V v = null;
        readLock.lock();
        try {
            v = map.get(key);
        } finally {
            readLock.unlock();
        }
        // 如果缓存中存在直接返回
        if (v != null) {
            return v;
        }
        // 如果缓存中不存在 查询数据库
        writeLock.lock();
        try {
            v = map.get(key);
            // 再次验证
            if (v == null) {
                //v = "从数据库获取";
                map.put(key, v);
            }
        }finally {
            writeLock.unlock();
        }
        return v;
    }

    public  void put(K key, V value) {
        writeLock.lock();
        try {
            map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public  void clear() {
        writeLock.lock();
        try {
            map.clear();
        }finally {
            writeLock.unlock();
        }
    }
}
