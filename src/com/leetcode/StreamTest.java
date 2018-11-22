package com.leetcode;

import java.text.CollationElementIterator;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author silent 1183611386@qq.com
 * @date 2018/11/19 14:58
 */
public class StreamTest {
    public static void main(String... args){
        List<String> wordList = new ArrayList<>();
        wordList.add("wo");
        wordList.add("wor");
        wordList.add("wod");
        wordList.add("worry");
        wordList.add("gorry");
        wordList.add("sorry");
        Map<Integer,List<String>> map =  wordList.stream().filter(s->s.startsWith("w")).collect(Collectors.groupingBy(String::length));
        System.out.println("map:"+map);
        wordList.stream().unordered().forEachOrdered(System.out::println);
        Pattern pattern = Pattern.compile("\\d+");
        Boolean a2 = Boolean.valueOf(true);
        Byte b2 = Byte.valueOf((byte) 123);
        Map<String,String> map2 = new HashMap<>();
//        System.out.println(startWithW.orElse("nothing"));
//        System.out.println(startWithW.get());
    }
}
