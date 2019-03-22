// 第一版的Union-Find
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size){
        id = new int[size];
        for(int i = 0; i < id.length; i++){
            id[i] = i; // 一开始初始化之后每个数都属于不同的id（集合）
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    // 查看p和q是否所属于同一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 查找元素p所对应的集合编号
    private int find(int p){
        if(p < 0 || p >= id.length){
            throw new IllegalArgumentException("p is out of bound");
        }
        return id[p];
    }

    // 合并元素p和q所属的集合
    // 注意这里所有属于p的集合和所有属于q的集合都会被合到一个集合里
    // 最后你选择p的id或q的id无所谓
    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if(pID == qID){
            return;
        }

        for(int i = 0; i < id.length; i++){
            if(id[i] == pID){
                id[i] = qID;
            }
        }
    }
}
