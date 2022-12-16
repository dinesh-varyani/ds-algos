package com.hubberspot.dsalgo.trie;

public class Trie {

   private TrieNode root;

   public Trie() {
      root = new TrieNode(); // root is empty 
   }

   private class TrieNode {
      private TrieNode[] children;
      private boolean isWord;

      public TrieNode() {
         this.children = new TrieNode[26]; // storing english words - a -> z    	    this.isWord = false;
      }
   }

   public void insert(String word) {
      if (word == null || word.isEmpty()) {
         throw new IllegalArgumentException("Invalid input");
      }

      word = word.toLowerCase();

      TrieNode current = root;
      for (int i = 0; i < word.length(); i++) {
         char c = word.charAt(i);
         int index = c - 'a';
         if (current.children[index] == null) {
            TrieNode node = new TrieNode();
            current.children[index] = node;
            current = node;
         } else {
            current = current.children[index];
         }
      }
      current.isWord = true;

   }

   public boolean search(String word) {
        if (word == null) return true;

        TrieNode current = root;
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (current.children[index] == null) return false;
            current = current.children[index];
        }
        if (!current.isWord)
            return false;
        return true;
    }

   public static void main(String[] args) {
      Trie trie = new Trie();
      trie.insert("cat");
      trie.insert("cab");
      trie.insert("son");
      trie.insert("so");
      System.out.println("Values inserted successfully !!!");
      
      System.out.println("son is in trie : " + trie.search("son"));
      System.out.println("dog is in trie : " + trie.search("dog"));
      System.out.println("cat is in trie : " + trie.search("cat"));
      System.out.println("cate is in trie : " + trie.search("cate"));
   }
}
