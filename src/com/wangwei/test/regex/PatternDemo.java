package com.wangwei.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author wangwei
 * @Date 2021/3/29 12:54 上午
 * @Version 1.0
 *
 */
public class PatternDemo {
    /**
     *  ^ 匹配输入字符串的开始位置。如果设置了 RegExp 对象的 Multiline 属性，^ 也匹配 '\n' 或 '\r' 之后的位置。
     *
     *  + 匹配前面的子表达式一次或多次。例如，'zo+' 能匹配 "zo" 以及 "zoo"，但不能匹配 "z"。+ 等价于 {1,}。
     *
     *  ? 匹配前面的子表达式零次或一次。例如，"do(es)?" 可以匹配 "do" 或 "does" 。? 等价于 {0,1}。
     *
     *  * 匹配前面的子表达式零次或多次。例如，zo* 能匹配 "z" 以及 "zoo"。* 等价于{0,}。
     *
     *  $ 匹配输入字符串的结束位置。如果设置了RegExp 对象的 Multiline 属性，$ 也匹配 '\n' 或 '\r' 之前的位置。
     *
     *  {n} n 是一个非负整数。匹配确定的 n 次。例如，'o{2}' 不能匹配 "Bob" 中的 'o'，但是能匹配 "food" 中的两个 o
     *
     *  . 匹配除换行符（\n、\r）之外的任何单个字符。要匹配包括 '\n' 在内的任何字符，请使用像"(.|\n)"的模式。
     */
    public static void main(String[] args) {
        String str = "booooooooooobby123";

        // 取以任意字符开头 查找以b起始中间是任意字符b结尾的字符串 ():取子串内容 .*: 任意字符 ?:强制从前往后遍历
        //Pattern pattern = Pattern.compile(".*?(b.*?b).*");

        // + 表示b和b之间至少出现一次或多次
        Pattern pattern = Pattern.compile(".*?(b.+b).*");
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.groupCount());
        while (matcher.find()){
            System.out.println(matcher.group(1));
        }
        //System.out.println(matcher.find());
        //System.out.println(matcher.group(1));

        String phone = "18701608711";
        Pattern pattern1 = Pattern.compile("1[86735][0-9]{9}");

        phone = "13sssss";
        // [^1]表示只要不是1出现9次就可以 [.*]括号内没有任何意义仅代表本身
        Pattern pattern2 = Pattern.compile("1[86735][^1]{9}");

        String name = "王w_伟";
        // \s：匹配空格 \S:匹配非空格 \w=[a-zA-Z0-9_]  \W:相反
        //Pattern nPattern = Pattern.compile("(王\\S+伟)");
        Pattern nPattern = Pattern.compile("(王\\W+伟)");
        Matcher nMatcher = nPattern.matcher(name);
        while (nMatcher.find()){
            System.out.println(nMatcher.group(1));
        }

        // 提取中文
        String study = "study in 北京大学";
        Pattern compile = Pattern.compile(".*?([\u4E00-\u9FA5]+大学)");
        Matcher matcher1 = compile.matcher(study);
        while (matcher1.find()){
            System.out.println(matcher1.group(1));
        }
    }
}
