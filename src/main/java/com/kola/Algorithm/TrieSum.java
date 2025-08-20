package com.kola.Algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * i.实现一个mapSum，实现两个函数:
 * ii. insert(string key, int val)，将key-val插入
 * ii. sum(string prefix)，找出以prefix为前缀的所有key的val之和
 */
public class TrieSum {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int passSum;
    }

    TrieNode root;
    Map<String,Integer> map = new HashMap<>();

    TrieSum(){
        root = new TrieNode();
    }

    private void insert(String key, int val){
        //相同key 则计算其与之前的val的差值 使用差值进行更新
        int dealt = val - map.getOrDefault(key,0);
        map.put(key,val);

        TrieNode cur = root;
        for(char c : key.toCharArray()){
            if(cur.children[c-'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
            cur.passSum += dealt;
        }
    }

    public int sum(String prefix){
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            if(cur.children[c-'a'] == null){
                return 0;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.passSum;
    }

    public static void main(String[] args) {
        TrieSum mapSum = new TrieSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap")); // 输出 3
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap")); // 输出 5
        mapSum.insert("apple", 2);            // 更新 apple 从 3 -> 2
        System.out.println(mapSum.sum("ap")); // 输出 4
        mapSum.insert("banana", 10);
        System.out.println(mapSum.sum("ba")); // 输出 10
        System.out.println(mapSum.sum(""));
    }
}
