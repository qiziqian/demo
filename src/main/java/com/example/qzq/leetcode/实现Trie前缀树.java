package com.example.qzq.leetcode;

/**
 * @Classname 实现Trie前缀树
 * @Description
 * @Date 2020/1/20 10:02
 * @Created by qiziqian
 */
public class 实现Trie前缀树 {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public 实现Trie前缀树() {
        root = new TrieNode('/');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                TrieNode node = new TrieNode(word.charAt(i));
                curr.children[index] = node;
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        if (curr.isEnd) return true;
        else return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return true;
    }
}

class TrieNode {
    char data;
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;

    public TrieNode(char data) {
        this.data = data;
    }
}