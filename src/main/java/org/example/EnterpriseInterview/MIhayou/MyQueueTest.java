package org.example.EnterpriseInterview.MIhayou;

import java.util.Stack;

/**
 * @author Chris Yang
 * created 2022-08-12 11:03
 **/

class MyQueue {

    Stack<Integer> stackA;
    Stack<Integer> stackB;

    public MyQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {
        stackA.push(x);
    }

    public int pop() {
        if(stackB.isEmpty()){
            while(!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }

    public int peek() {
        if(stackB.isEmpty()){
            while(!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
        }
        return stackB.peek();
    }

    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}

public class MyQueueTest {


}
