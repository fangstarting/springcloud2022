package com.test;


import java.util.*;

/**
 * @program springcloud2022
 * @description
 * @Author FFang
 * @Create 2022-06-02 18:22
 */
public class MyTest {


    public static void main(String[] args) {
        MyTest m = new MyTest();
        m.t1();
    }


    public void t3() {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int v = in.nextInt();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len = Math.min(c1.length, c2.length);
        ArrayList<Integer> charLens = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int sub = 0;
            Integer charLen = null;
            for (int j = i; j < len; j++) {
                sub += Math.abs(c1[j] - c2[j]);
                if (sub > v) {
                    charLen = j - i;
                    break;
                }
            }
            if (charLen != null) {
                charLens.add(charLen);
            }
        }
        Object[] objects = charLens.toArray();
        Arrays.sort(objects);
        if (objects.length != 0) {
            System.out.println(objects[objects.length - 1]);
        } else {
            System.out.println(0);
        }
    }

    public void t2(){
        Scanner in = new Scanner(System.in);
        String row1 = in.next();
        String row2 = in.next();
        String[] r1 = row1.split(",");
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : r1) {
            String[] a = s.split(":");
            int key = Integer.parseInt(a[0]);
            int val = Integer.parseInt(a[1]);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + val);
            } else {
                map.put(key, val);
            }
        }
        String[] r2 = row2.split(",");
        StringBuffer sb = new StringBuffer();
        for (String s : r2) {
            int size = Integer.valueOf(s);
            Set<Integer> integers = map.keySet();
            List<Integer> list = new ArrayList<>();
            for (Integer integer : integers) {
                Integer val = map.get(integer);
                if (size <= integer && val > 0) {
                    list.add(integer);
                }
            }
            if (list.size() == 0) {
                sb.append("false,");
            } else {
                Object[] objects = list.toArray();
                Arrays.sort(objects);
                Integer key = (Integer) objects[0];
                Integer v = map.get(key);
                map.put(key, --v);
                sb.append("true,");
            }
        }
        String s = sb.toString().substring(0, sb.toString().length() - 1);
        System.out.println(s);
    }



    public void t1() {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.println(number + "=" + number);
        int result = 1;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= number / 2 + 1; i++) {
            int sum = 0;
            StringBuffer sb = new StringBuffer();
            for (int j = i; j <= number; j++) {
                sb.append(j + "+");
                sum += j;
                if (sum == number) {
                    result++;
                    String news = String.valueOf(sb);
                    list.add(number + "=" + news.substring(0, news.length() - 1));
                }
            }
        }
        Object[] array = list.toArray();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                Object tem;
                if (array[j].toString().length() > array[j + 1].toString().length()) {
                    tem = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tem;
                }
            }
        }
        for (Object o : array) {
            System.out.println(o);
        }
        System.out.println("Result:" + result);
    }
}
