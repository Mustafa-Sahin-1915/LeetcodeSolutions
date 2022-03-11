package leetcodesolutions;

import java.math.BigInteger;

/*
2. Add Two Numbers (Medium)
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order,
and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero,
except the number 0 itself.

l1 : [2]->[4]->[3]
l2 : [5]->[6]->[4]

Output: [7]->[0]->[8]

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

[9]
[1,9,9,9,9,9,9,9,9,9]
Output
[8,0,4,5,6,0,0,1,4,1]
Expected
[0,0,0,0,0,0,0,0,0,0,1]

* */
/*

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 } */
class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbersSolution {
    public static void main(String[] args) {
        //[9]
        ListNode l1 = new ListNode(9,null);
        //[1,9,9]
        ListNode l2 = new ListNode(1,new ListNode(9,new ListNode(9,null)));

        ListNode res = addTwoNumbers2(l1,l2);
        StringBuilder num1 = new StringBuilder();
        while(res!=null){
            num1.append(String.valueOf(res.val));
            res = res.next;
        }
        System.out.println(num1.toString());
        //0001
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=null;
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        while(l1!=null){
            num1.append(String.valueOf(l1.val));
            l1 = l1.next;
        }
        while(l2!=null){
            num2.append(String.valueOf(l2.val));
            l2 = l2.next;
        }
        num1 = num1.reverse();
        num2 = num2.reverse();
        BigInteger bg1 = new BigInteger(num1.toString());
        BigInteger bg2 = new BigInteger(num2.toString());
        bg1 = bg1.add(bg2);

        char v[] = bg1.toString().toCharArray();
        ListNode next = null;
        for (int i =0 ; i<v.length ; i++) {
            result = new ListNode(Integer.valueOf(""+v[i]),next);
            next = result;
        }
        return result;
    }


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result=null;
        ListNode next = null;
        int leap =0;
        int val = 0;
        int sum =0;
        while(l1!=null || l2!=null){
            if (l1!=null){
                if (l2!=null){
                    sum = l1.val + l2.val + leap;
                    if (sum/10==0){
                        leap = 0;
                        val = sum;
                    }else{
                        leap = sum /10;
                        val = sum % 10;
                    }
                }else{
                    val = l1.val + leap;
                    if (val/10==0){
                        leap = 0;
                    }else{
                        leap = val /10;
                        val = val % 10;
                    }
                }
            }else if (l2!=null){
                val = l2.val + leap;
                if (val/10==0){
                    leap = 0;
                }else{
                    leap = val /10;
                    val = val % 10;
                }
            }
            result =new ListNode(val,next);
            next = result;
            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;
        }
        if (leap!=0){
            result =new ListNode(leap,next);
        }
        ListNode result2 =null;
        next = null;
        while (result!=null){
            result2 = new ListNode(result.val,next);
            result = result.next;
            next =result2;
        }
        return result2;
    }
}
