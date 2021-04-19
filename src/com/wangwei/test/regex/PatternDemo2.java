package com.wangwei.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author wangwei
 * @Date 2021/3/29 2:18 上午
 * @Version 1.0
 */
public class PatternDemo2 {
    public static void main(String[] args) {
        String text = "xxx出生于2008年";
        //Pattern pattern = Pattern.compile(".*(\\d{4})年");
        //Pattern pattern = Pattern.compile(".(\\d+)年");
        Pattern pattern = Pattern.compile(".*?(\\d+)年");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group(1));
        }

        String text1 = "xxx出生于2008年6月1日";
        text1 = "xxx出生于2008/6/1";
        text1 = "xxx出生于2008-6-1";
        text1 = "xxx出生于2008-06-01";
        text1 = "xxx出生于2008-06";

        Pattern compile = Pattern.compile(".*出生于(\\d{4}[年/-]\\d{1,2}([月/-]\\d{1,2}[日]|[月/-]\\d{1,2}$|$)).*");
        Matcher matcher1 = compile.matcher(text1);
        while (matcher1.find()){
            System.out.println(matcher1.group(1));
        }

    }
}
