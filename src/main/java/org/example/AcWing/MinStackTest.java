package org.example.AcWing;

import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-10-10 17:12
 **/
class MinStack {

    Stack<Integer> stackV;
    Stack<Integer> stackMin;

    /** initialize your data structure here. */
    public MinStack() {
        stackV = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        stackV.push(x);
        if(stackMin.isEmpty() || stackMin.peek() >= x){
            stackMin.push(x);
        }
    }

    public void pop() {
        if(stackMin.peek() == stackV.peek()) stackMin.pop();
        stackV.pop();
    }

    public int top() {
        return stackV.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


public class MinStackTest{
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(-1);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
