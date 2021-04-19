package com.wangwei.test.binary;

/**
 * @Author wangwei
 * @Date 2021/3/29 4:54 下午
 * @Version 1.0
 */
public class BinaryDemo {
    public static void main(String[] args) {
        /**
         *  2进制转10进制就是每个数字乘与2向加的过程 例子: 110 -> 0*2o+1*21+1*22
         *
         *  10进制转2进制就是不断除2的过程
         *
         *  4个2进制位代表一个16进制 因为：1111最大值是 15 例子 0 1 0 1 - 1 0 1 0
         *                                                  8 4 2 1 - 8 4 2 1
         *                                                  5-10（A）
         *                                                  所以0101-1010的16进制是0x5A
         *   -6是6的2进制取反+1
         *   6的2进制内存表现形式： 0000-0000 0000-0000 0000-0000 0000-0110
         *
         *   -6的2进制内存表现形式：1111-1111 1111-1111 1111-1111 1111-1001
         *                   +   0000-0000 0000-0000 0000-0000 0000-0001
         *
         *   3<<2 : 3左移2位相当于 3*22 移3<<4 2*24
         *   6>>2 : 6右移2位相当于 6/22
         */
        System.out.println(6/4);
        System.out.println(Integer.toBinaryString(6));
        System.out.println(7^4^4);
        System.out.println(7^0);

    }

    public static void toBinary(int num){
        while (true){

        }
    }
}
