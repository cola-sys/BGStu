package com.kola.Algorithm;

import java.util.*;

public class KWayMerge {
    // 定义一个节点类，记录元素值、来自哪个数组、该数组中的下标
    static class Node {
        int val;      // 元素值
        int row;      // 属于第几个数组
        int index;    // 在该数组中的索引

        Node(int val, int row, int index) {
            this.val = val;
            this.row = row;
            this.index = index;
        }
    }

    public static List<Integer> mergeKSortedArrays(List<int[]> lists) {
        List<Integer> result = new ArrayList<>();

        // 最小堆：根据 val 排序
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // 初始化，把每个数组的第一个元素放入堆
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).length > 0) {
                minHeap.offer(new Node(lists.get(i)[0], i, 0));
            }
        }

        // 循环取最小元素
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            result.add(cur.val);

            // 把该数组的下一个元素放入堆
            if (cur.index + 1 < lists.get(cur.row).length) {
                minHeap.offer(new Node(lists.get(cur.row)[cur.index + 1], cur.row, cur.index + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<int[]> lists = new ArrayList<>();
        lists.add(new int[]{1, 4, 7});
        lists.add(new int[]{2, 5, 8});
        lists.add(new int[]{3, 6, 9});

        List<Integer> merged = mergeKSortedArrays(lists);
        System.out.println(merged);  // 输出: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
