public class UnionFind2 implements UF {

    private int[] parent; // parent[i]表示第i个元素指向哪个节点

    public UnionFind2(int size){
        parent = new int[size];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i; // 初始化的时候每个节点都指向自己
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    // 查看p和q是否属于同一个集合
    // O(h)复杂度，h为树的高度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 查找过程，查找元素p所对应的集合编号
    // O(h)的复杂度，h为树的高度
    private int find(int p){
        if(p < 0 || p >= parent.length){
            throw new IllegalArgumentException("p is out of bound");
        }
        // 一直while循环找到p节点所属的根节点
        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot){
            return;
        }
        parent[pRoot] = qRoot;
    }
}
