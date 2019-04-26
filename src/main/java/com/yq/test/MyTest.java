package com.yq.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class MyTest {


    public static void main(String[] args) {


        ReentrantLock lock = new ReentrantLock();


        ArrayList<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("3");
        list1.add("2");


        System.out.println();


        sortUseJava8(list1);

        System.out.println(list1);

//        List<Integer> numberList = new ArrayList<>();
//        numberList.add(-3);
//        numberList.add(-1);
//        numberList.add(0);
//        numberList.add(1);
//        numberList.add(2);
//        numberList.add(1);
//        numberList.add(3);


//        Entry<String, String> e = new Entry<>("cyq0", "haha0", null, 0);
//        Entry<String, String> e1 = new Entry<>("cyq1", "haha1", e, 1);
//
//        Entry<String, String> next = e1.next;
//        e1.next = null;
//
//        Entry<String, String> aa = next;
//
//        System.out.println(aa);


    }


    private static void sortUseJava7(ArrayList<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    private static void sortUseJava8(ArrayList<String> list) {
        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
    }



    static class Entry<K, V>{
        final K key;
        V value;
        Entry<K,V> next;
        int hash;

        Entry(K k, V v, Entry<K,V> n, int h) {
            value = v;
            next = n;
            key = k;
            hash = h;
        }
    }


    /**
     * 获取最大值
     * @return
     */
    public static Integer maxNumber(List<Integer> numberList) {
        if (numberList == null || numberList.size() <= 0) {
            return null;
        }
        //先排序(降序)
        Collections.sort(numberList, new Comparator<Integer>() {
            @Override
            public int compare(Integer p1, Integer p2) {
                if (p1 > p2) {
                    return -1;
                } else if (p1 == p2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        //用于保存正数
        List<Integer> positiveNumberList = new ArrayList<>();
        //用于保存零
        List<Integer> zeroList = new ArrayList<>();
        //用于保存负数
        List<Integer> negativeNumberList = new ArrayList<>();
        //将数据分类（正数、零、负数）
        for (Integer number : numberList) {
            if (number > 0) {
                positiveNumberList.add(number);
            } else if (number < 0) {
                negativeNumberList.add(number);
            } else {
                zeroList.add(number);
            }
        }
        //记录最大的结果
        int max = 0;
        //记录没被组合的数
        Integer[] restOfNumberArray = {0, 0, 0};

        //处理正数
        if (positiveNumberList.size() > 0) {
            for (int i = 0; i < positiveNumberList.size() - 1; i += 2) {
                max += positiveNumberList.get(i) * positiveNumberList.get(i + 1);
            }
            if (positiveNumberList.size() % 2 != 0) { //不可以整除2
                restOfNumberArray[0] = positiveNumberList.get(positiveNumberList.size() - 1);
            }
        }
        //处理负数
        if (negativeNumberList.size() > 0) {
            for (int i = negativeNumberList.size() - 1; i - 1 >= 0; i -= 2) {
                max += negativeNumberList.get(i) * negativeNumberList.get(i - 1);
            }
            if (negativeNumberList.size() % 2 != 0) {
                restOfNumberArray[1] = negativeNumberList.get(0);
            }
        }
        //如果有零，那就可以抵消剩下来的那个负数
        if (zeroList.size() > 0 && restOfNumberArray[1] != null) {
            restOfNumberArray[1] = 0;
        }

        for (Integer arg : restOfNumberArray) {
            max += arg;
        }

        return max;

    }

}
