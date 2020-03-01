package LeetCode_prictice;

public class Trie {
    /** Initialize your data structure here. */
    class Node{
        private Node[] next;
        private boolean isEnd;
        public Node(){
            next=new Node[26];
            isEnd=false;
        }
    }

    private Node root;
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node curNode = root;
        for (int i = 0; i < chars.length; i++) {
            if(curNode.next[chars[i]-'a']==null){
                curNode.next[chars[i]-'a']= new Node();
            }
            if(chars.length-1==i){
                curNode.next[chars[i]-'a'].isEnd=true;
            }
            curNode=curNode.next[chars[i]-'a'];
        }

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curNode = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if(curNode.next[chars[i]-'a']==null){
                return false;
            }else {
                curNode=curNode.next[chars[i]-'a'];
            }
            if(i==word.length()-1 && curNode.isEnd==true){
                return true;
            }
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        Node curNode = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if(curNode.next[chars[i]-'a']==null){
                return false;
            }else {
                curNode=curNode.next[chars[i]-'a'];
            }
            if(i==word.length()-1){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        String word = "abc";
        Trie tire = new Trie();
        tire.insert(word);
        tire.insert("bcd");
        System.out.println(tire.search(word));
        System.out.println(tire.startsWith("ab"));
    }
}
