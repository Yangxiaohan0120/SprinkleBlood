package org.example.AcWing;

import java.util.PriorityQueue;

/**
 * @author Chris Yang
 * created 2022-10-17 16:48
 **/
public class MedianofNumbers {

    // 最大堆，存储较大的一半值，小数在前
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

    // 最小堆，存储较小的一半值，大数在前
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> b-a);

    int count = 0;

    public void insert(Integer num) {
        // 偶数，插入使其不平衡，存在最小堆中，找中值直接返回最小堆的堆顶（最大值）
        if((count++ & 1) == 0){
            maxHeap.add(num);
            num = maxHeap.poll();
            minHeap.add(num);
        }else{
            // 奇数，插入使其平衡，所以应该插到最大堆中
            // 先插入最小堆，找到最大值再插入最大堆中
            minHeap.add(num);
            num = minHeap.poll();
            maxHeap.add(num);
        }
    }

    public Double getMedian() {
        // 偶数
        if(count == 0)return 0.0;
        if((count & 1) == 0){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }else{
            return minHeap.peek() / 1.0;
        }
    }
}
