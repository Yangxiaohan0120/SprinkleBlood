package org.example.AcWing;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-08-16 16:27
 **/
public class BlockSorting {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        if(n == 0 || n == 1)return 1;
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        HashSet<Integer> times = new HashSet<>();
        times.add(0);
        stackA.push(arr[0]);
        for (int i = 1; i < n; i++) {
            if(arr[i] >= stackA.peek()){
                times.add(stackA.size());
                stackA.push(arr[i]);
            }else{
                while(true){
                    stackB.push(stackA.pop());
                    if(stackA.isEmpty() || stackA.peek() < arr[i]){
                        break;
                    }
                }
                times.add(stackA.size());
                stackA.push(arr[i]);
                while(!stackB.isEmpty()){
                    stackA.push(stackB.pop());
                }
            }
        }
        return times.size();
    }

    public int maxChunksToSorted1(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        // 只保留每一个块的最大值
        for(int num : arr) {
            if(!stack.isEmpty() && num < stack.peek()) {
                int head = stack.pop();
                while(!stack.isEmpty() && num < stack.peek()) stack.pop();
                stack.push(head);
            }
            else stack.push(num);
        }
        return stack.size();
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,4,3,3,6,5,4};
        System.out.println(new BlockSorting().maxChunksToSorted1(arr));
    }

}
