package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Question 1:
        int[] nums = {0, 1, 3, 50, 75};
        findMissingRanges(nums, 0, 99);
        System.out.println(findMissingRanges(nums, 0, 99));

        //Question 2:


    }

    //Question 1:
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        int next = lower;
        for (int i = 0; i < nums.length; i++) {
            // 1. We don't need to add [Integer.MAX_VALUE, ...] to result
            if(lower == Integer.MAX_VALUE) return res;
            if (nums[i] < next) {
                continue;
            }
            if (nums[i] == next) {
                next++;
                continue;
            }
            res.add(getRange(next, nums[i] - 1));
            // 2. We don't need to proceed after we have process Integer.MAX_VALUE in array
            if(nums[i] == Integer.MAX_VALUE) return res;
            next = nums[i] + 1;
        }

        if (next <= upper) {
            res.add(getRange(next, upper));
        }
        return res;
    }

    public static String getRange(int n1, int n2) {
        return n1 == n2 ? String.valueOf(n1) : String.format("%d->%d" , n1, n2);
    }


    //Question 2:
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2){
    ListNode head = null;
    ListNode temp = null;
    int carry = 0;
    while (l1 != null || l2 != null) {
        int sum = carry;

        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }

        ListNode node = new ListNode(sum % 10);
        carry = sum / 10;
        if (temp == null) {
            temp = head = node;
        }else{
            temp.next = node;
            temp = temp.next;
        }
    }

    if (carry > 0) {
        temp.next = new ListNode(carry);
    }
    return head;
    }





}
