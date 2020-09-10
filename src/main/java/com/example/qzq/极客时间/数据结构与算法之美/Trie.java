package com.example.qzq.极客时间.数据结构与算法之美;

/**
 * @Classname Trie
 * @Description Trie树
 * @Date 2019/11/11 14:21
 * @Created by qiziqian
 */
public class Trie {

    private TrieNode root = new TrieNode('/'); // 存储无意义字符

    //插入一个单词
    public void insert(char[] text) {
        TrieNode trieNode = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (root.children[index] == null) {
                TrieNode node = new TrieNode(text[i]);
                trieNode.children[index] = node;
            }
            trieNode = trieNode.children[index];
        }
        trieNode.isEndingChar = true;
    }

    public boolean find(char[] pattern) {
        TrieNode trieNode = root;
        for (int i = 0; i < pattern.length; i++) {
            int index = pattern[i] - 'a';
            if (trieNode.children[index] == null) {
                return false;
            }
            trieNode = trieNode.children[index];
        }
        return trieNode.isEndingChar;
    }

    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }

    }
}
