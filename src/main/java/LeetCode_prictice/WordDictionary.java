package LeetCode_prictice;

/*
    letcode121
    2020/2/20
 */
public class WordDictionary {


    class Node {
        private Node[] next;
        boolean isEnd;

        public Node() {
            //数组里面的每一个对象都是null值，则在使用的时候数组中的每一个对象必须分别进行实例化操作。
            next = new Node[26];

            this.isEnd = false;
        }

    }

    private  Node root;
    public WordDictionary() {
        root = new Node();
    }


    /**
     * Adds a word into the data structure.
     */
    public  void addWord(String word) {
        char[] chars = word.toCharArray();
        Node curNode = root;
        for (int i = 0; i < chars.length; i++) {
            Node chargeNode = curNode.next[chars[i] - 'a'];
            //chargeNode指向了一个空地址，当chargeNode生成新的地址的时候，curnode.next是找不到的！！所以这才会导致赋值失败
            if (chargeNode == null) {
                curNode.next[chars[i] - 'a']= new Node();
            }
            if (i == chars.length - 1) {
                curNode.next[chars[i] - 'a'].isEnd=true;
            }
            curNode = curNode.next[chars[i] - 'a'];
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node curNode = root;
        for (int i = 0; i < chars.length; i++) {
            Node chargeNode = curNode.next[chars[i] - 'a'];
            if (chargeNode == null) {
                return false;
            }
            if(chargeNode.isEnd==true && i==chars.length-1){
                return true;
            }
            curNode=chargeNode;
        }
        return false;
    }

    public static void main(String[] args) {
        String word = "hello";
        String word2 = "hekk";
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord(word);
        wordDictionary.addWord(word2);
        wordDictionary.search(word2);
    }
}
