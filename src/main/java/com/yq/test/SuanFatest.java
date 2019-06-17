package com.yq.test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode {
    private Integer val;
    private ListNode next;
    public ListNode(Integer val) {
        this.val = val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public int getVal() {
        return this.val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return this.next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


public class SuanFatest {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //获取a里面的数
        List<Integer> listA = new ArrayList<>();
        listA.add(l1.getVal());
        ListNode xx = l1;
        while (xx.getNext() != null) {
            listA.add(xx.getNext().getVal());
            xx = xx.getNext();
        }
        Collections.reverse(listA);
        int resultA = getNum(listA);

        //获取b里面的数
        List<Integer> listB = new ArrayList<>();
        listB.add(l2.getVal());
        ListNode cc = l2;
        while (cc.getNext() != null) {
            listB.add(cc.getNext().getVal());
            cc = cc.getNext();
        }
        Collections.reverse(listB);
        int resultB = getNum(listB);

        String resultC = resultA + resultB + "";
        char[] reChar = resultC.toCharArray();
        List<ListNode> rrList = new ArrayList<>();
        for (int i = reChar.length - 1; i >= 0; i--) {
            rrList.add(new ListNode(Integer.valueOf(reChar[i])));
        }

        for (int i = 0; i < rrList.size(); i++) {
            if (i + 1 < rrList.size() - 1) {
                rrList.get(i).setNext(rrList.get(i + 1));
            }
        }
        return rrList.get(0);
    }


    private static int getNum(List<Integer> list) {
        StringBuffer ff = new StringBuffer("1");
        for (int i = 0; i < list.size(); i++) {
            ff.append("0");
        }
        Integer vv = Integer.valueOf(ff.toString());
        Integer result = 0;
        for (Integer x : list) {
            result += x * vv;
            vv = vv / 10;
        }
        return result;
    }



    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(3);
        a.setNext(a1);
        a1.setNext(a2);

        ListNode b = new ListNode(5);
        ListNode b1 = new ListNode(6);
        ListNode b2 = new ListNode(4);
        b.setNext(b1);
        b1.setNext(b2);

        addTwoNumbers(a, b);
        System.out.println(addTwoNumbers(a, b));

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] returns = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int aa = nums[i];
            int xx = target - aa;
            if (isContain(nums, xx) != -1) {
                if (aa == xx) {
                    if (isContain(nums, xx) != i) {
                        returns[0] = i;
                        returns[1] = isContain(nums, xx);
                        break;
                    }
                } else {
                    returns[0] = i;
                    returns[1] = isContain(nums, xx);
                    break;
                }
            }
        }
        return returns;
    }

    private static int isContain(int[] array, int target) {
        int isContain = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                isContain = i;
                break;
            }
        }
        return isContain;
    }


}
