package com.codecool.streams;

import com.google.common.base.CharMatcher;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kata {
    public static void main(String[] args) {
        System.out.println(charCountImperativeApproach("FIZZBUZZ fizzbuzz", '0'));
        System.out.println(charCountUsingRegularExpressions("FIZZBUZZ"));
        System.out.println(charCountUsingJava8Features("FIZZBUZZ", 'z'));
        System.out.println(charCountUsingStringUtils("FIZZBUZZ fizzbuzz", 'Z'));
        System.out.println(charCountUsingGuava("FIZZBUZZ", 'z'));
    }


    public static int charCountImperativeApproach(String str, char c) {

        int count = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }


    //Needs regex utils
    public static int charCountUsingRegularExpressions(String str) {

        str = str.toLowerCase();
        Pattern pattern = Pattern.compile("[^z]*z");
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }


    public static long charCountUsingJava8Features(String str, char c) {

        str = str.toLowerCase();
        long count = str.chars().filter(ch -> ch == c).count();
//        long count = str.codePoints().filter(ch -> == c).count();
        return count;
    }


    //Needs String Utils (External Library) needs dependecy in pom.xml

    public static int charCountUsingStringUtils(String str, char c) {
        int count = 0;
        int count2 = 0;
        str = str.toLowerCase();
        if (Character.isUpperCase(c)) {
            count = StringUtils.countMatches(str, c);
        }
        if (Character.isLowerCase(c)) {
            count2 = StringUtils.countMatches(str, c);
        }
        return count + count2;
    }

    public static int charCountUsingGuava(String str, char c) {

        str = str.toLowerCase();
        int count = CharMatcher.is(c).countIn(str);
        return count;
    }
}
