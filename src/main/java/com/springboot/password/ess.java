package com.springboot.password;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class ess {
    public static String generateInviteCode(int len) {
        ess.isTrue(len > 0, "长度要大于0");

        char[] chars = {'0','1','2','3','4',
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                'a','c','d','e'};
        Random random = new Random();
        char[] inviteChars = new char[len];
        for (int i = 0; i < len; i++) {
            inviteChars[i] = chars[random.nextInt(chars.length)];
        }
        return String.valueOf(inviteChars);
    }

    private static void isTrue(boolean b, String 长度要大于0) {
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Set set = new HashSet();
        for (int i = 0; i < 1000000; i++) {
            set.add(generateInviteCode(6));
        }
        //生成邀请码的个数
        Iterator iterator = set.iterator();
        for (int i = 0; i < 1; i++) {
            System.out.println(iterator.next());
        }
        System.out.println();
        //System.out.println(set.size());
    }
}
