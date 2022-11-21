package org.example.AcWing;

import java.util.PriorityQueue;

/**
 * @author Chris Yang
 * created 2022-10-17 16:48
 **/
public class MedianofNumbers {

    // ���ѣ��洢�ϴ��һ��ֵ��С����ǰ
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

    // ��С�ѣ��洢��С��һ��ֵ��������ǰ
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> b-a);

    int count = 0;

    public void insert(Integer num) {
        // ż��������ʹ�䲻ƽ�⣬������С���У�����ֱֵ�ӷ�����С�ѵĶѶ������ֵ��
        if((count++ & 1) == 0){
            maxHeap.add(num);
            num = maxHeap.poll();
            minHeap.add(num);
        }else{
            // ����������ʹ��ƽ�⣬����Ӧ�ò嵽������
            // �Ȳ�����С�ѣ��ҵ����ֵ�ٲ���������
            minHeap.add(num);
            num = minHeap.poll();
            maxHeap.add(num);
        }
    }

    public Double getMedian() {
        // ż��
        if(count == 0)return 0.0;
        if((count & 1) == 0){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }else{
            return minHeap.peek() / 1.0;
        }
    }
}
