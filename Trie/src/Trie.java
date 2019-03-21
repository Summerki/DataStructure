import java.util.TreeMap;

public class Trie {
    private class Node{
        public boolean isWord; // 为了区分pan和pane这种有公共部分的情况
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    // 获得Trie中存储的单词数量
    public int getSize(){
        return size;
    }

    // 向Trie中添加一个新的单词word
    public void add(String word){
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur = cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if(!cur.isWord){ // 这里的判断是为了避免添加一个重复元素
            cur.isWord = true;
            size++;
        }
    }

    // 查询单词word是否在Trie中
    public boolean contains(String word){
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord; // 这里不能直接返回true，要返回isWord属性判断是否真的有这个单词(pan和panda)
    }

    // 查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix){
        Node cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

}
