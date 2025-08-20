package com.kola.test;

import org.w3c.dom.Node;

import java.util.List;
import java.util.PriorityQueue;

public class KWayMerge {

    static class Node{
        int val;
        int row;
        int index;
        public Node(int val,int row,int index){
            this.val = val;
            this.row = row;
            this.index = index;
        }
    }

    public void merge(List<List<Integer>> list,List<Integer> res){
        PriorityQueue<Node> p = new PriorityQueue<>((o1,o2)->o1.val-o2.val);
        for (int i = 0; i < list.size(); i++) {
        //p.offer(new Node(list.get(i).get())
        }
    }

}
