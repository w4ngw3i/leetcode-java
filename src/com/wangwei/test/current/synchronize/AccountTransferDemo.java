package com.wangwei.test.current.synchronize;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangwei
 * @version 1.0
 * @date 2021-09-22 14:38
 */
public class AccountTransferDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        Account a = new Account("A");
        System.out.println("A:" + a.getBalance());
        Account b = new Account("B");
        System.out.println("B:" + b.getBalance());
        Account c = new Account("C");
        System.out.println("C:" + c.getBalance());
        for (int i = 1; i <= 100; i++) {
            threadPool.submit(() -> a.transfer(b, new BigDecimal(10)));
            threadPool.submit(() -> b.transfer(c, new BigDecimal(10)));
        }
        Thread.sleep(10000);
        System.out.println("A:" + a.getBalance());
        System.out.println("B:"+ b.getBalance());
        System.out.println("C:" + c.getBalance());
    }
}
