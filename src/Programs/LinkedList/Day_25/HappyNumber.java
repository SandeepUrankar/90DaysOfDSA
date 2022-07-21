package Programs.LinkedList.Day_25;

/*
https://leetcode.com/problems/happy-number/
A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */

public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = getSquare(slow);
            fast = getSquare(getSquare(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int getSquare(int number) {
        int squared = 0;
        while (number > 0) {
            int rem = number % 10;
            squared += rem * rem;
            number /= 10;
        }
        return squared;
    }

    //https://leetcode.com/problems/middle-of-the-linked-list/
    //Method for Middle of Linked list.
    public class ListNode {
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


    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(19));
    }
}
