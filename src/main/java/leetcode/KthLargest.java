package leetcode;

import java.util.Queue;
import java.util.PriorityQueue;

class KthLargest {
    int k;
    Queue<Integer> mq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) add(num);
    }

    public int add(int val) {
        mq.offer(val);
        if (mq.size() > k) mq.poll();
        return mq.peek();
    }

    public static void main(String[] args) {
        KthLargest k = new KthLargest(7, new int[]{-10, 1, 3, 1, 4, 10, 3, 9, 4, 5, 1});
        System.out.println(k.add(3));
        System.out.println(k.add(2));
        System.out.println(k.add(3));
        System.out.println(k.add(1));
        System.out.println(k.add(2));
        System.out.println(k.add(4));
        System.out.println(k.add(5));
        System.out.println(k.add(5));
        System.out.println(k.add(6));
        System.out.println(k.add(7));
        System.out.println(k.add(8));
        System.out.println(k.add(8));
        System.out.println(k.add(2));
        System.out.println(k.add(3));
        System.out.println(k.add(1));
        System.out.println(k.add(1));
        System.out.println(k.add(1));
        System.out.println(k.add(10));
        System.out.println(k.add(11));
        System.out.println(k.add(5));
        System.out.println(k.add(6));
        System.out.println(k.add(2));
        System.out.println(k.add(4));
        System.out.println(k.add(7));
        System.out.println(k.add(8));
        System.out.println(k.add(5));
        System.out.println(k.add(6));
//        System.out.println(k.add());

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
