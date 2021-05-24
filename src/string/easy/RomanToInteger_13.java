package string.easy;

import sun.security.util.Length;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger_13 {

    public static void main(String[] args) {
        System.out.println(romanToInteger("IV"));
    }

    public static int romanToInteger(String s){
/*        if (s == null || s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);*/

        int num = 0, lastNum =0, value;

        for (int i = s.length() -1; i >= 0; i--){
            value = value(s.charAt(i));

            if (value >= lastNum){
                num += value;
            }else {
                num -= value;
            }
            lastNum = value;
        }
        return num;
    }

    public static int value(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}


