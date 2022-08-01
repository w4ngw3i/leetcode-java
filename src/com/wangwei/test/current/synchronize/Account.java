package com.wangwei.test.current.synchronize;

import javax.lang.model.element.VariableElement;
import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wangwei
 * @version 1.0
 * @date 2021-09-22 14:31
 */
public class Account {
    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    Lock readLock = rwLock.readLock();
    Lock writeLock = rwLock.writeLock();

    private String name;

    private BigDecimal balance;

    public Account(String name) {
        this(name, new BigDecimal(1000));
    }

    public Account(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
        //readLock.lock();
        //try {
        //    return balance;
        //}finally {
        //    readLock.unlock();
        //}
    }

    public void setBalance(BigDecimal balance) {
        writeLock.lock();
        try {
            this.balance = balance;
        }finally {
            writeLock.unlock();
        }
    }

    // 有并发问题，因为使用的不是同一把锁
    public BigDecimal transfer(Account targetAccount, BigDecimal amount) {
        synchronized (Account.class) {
            if (this.balance.compareTo(amount) >= 0) {
                this.balance = balance.subtract(amount);
                targetAccount.balance = targetAccount.balance.add(amount);
            }
            return balance;
        }
    }

    //public void transfer(Account targetAccount, BigDecimal amount) {
    //    writeLock.lock();
    //    try {
    //        if (this.balance.compareTo(amount) > 0) {
    //            this.balance = balance.subtract(amount);
    //            targetAccount.balance = targetAccount.balance.add(amount);
    //        }
    //    }finally {
    //        writeLock.unlock();
    //    }
    //}
}
