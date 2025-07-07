package StackAndQueues;

import java.util.Deque;
import java.util.LinkedList;

public class SumOfMinMaxOfSubarraySizeK {
    public static void main(String[] args) {
        int arr[] = { 2, 5, -1, 7, -3, -1, -2 },
                K = 4;
        int ans = help(arr, K);
        System.out.println(ans);
    }

    public static int help(int[] arr, int K) {
        int sum = 0;
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        int start = 0;
        int end = 0;

        // First window
        while (end < K) {
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[end]) {
                minDeque.pollLast();
            }
            minDeque.addLast(end);

            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[end]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(end);
            end++;
        }
        sum += arr[minDeque.peekFirst()] + arr[maxDeque.peekFirst()];

        // Remaining windows
        while (end < arr.length) {
            start++;

            if (minDeque.peekFirst() < start) {
                minDeque.pollFirst();
            }
            if (maxDeque.peekFirst() < start) {
                maxDeque.pollFirst();
            }

            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[end]) {
                minDeque.pollLast();
            }
            minDeque.addLast(end);

            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[end]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(end);

            sum += arr[minDeque.peekFirst()] + arr[maxDeque.peekFirst()];
            end++;
        }
        return sum;
    }
}
