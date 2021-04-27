package com.wangwei.test;

/**
 * @Author wangwei
 * @Date 2021/4/25 8:03 下午
 * @Version 1.0
 *  水先花数
 */
public class WaterFlower {
    public static void main(String[] args) {
        System.out.println(Math.pow(2, 3));
        // 768
        for (int i=100; i<1000; i++){
            int gw = i%10;
            int sw = (i/10)%10;
            int bw = (i/100)%10;
            //153
            //370
            //371
            //407
            //if ( i == ((gw*gw*gw) + (sw*sw*sw) + (bw*bw*bw))){
            //    System.out.println(i);
            //}
            if ( i == ((Math.pow(gw, 3)) + (Math.pow(bw, 3)) + (Math.pow(bw, 3)))){
                System.out.println(i);
            }
        }
    }
}
