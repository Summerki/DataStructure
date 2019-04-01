import java.util.TreeMap;

public class HashTable<K, V> {

    // 定义一个素数表，哈希表的容量空间全是这个素数表的内容
    private final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private static final int upperTol = 10; // 上界
    private static final int lowerTol = 2; // 下界
    private int capacityIndex = 0; // 一个指向素数表的索引

    private TreeMap<K, V>[] hashtable;
    private int M; // 选择合适的素数
    private int size; // 哈希表元素个数


    public HashTable(int M){
        this.M = capacity[capacityIndex];
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++){
            hashtable[i] = new TreeMap<>();
        }
    }


    // 计算hash值
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize(){
        return size;
    }

    // 增
    public void add(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key)){
            map.put(key, value); // 如果key的hash值已经存在，则将value值修改
        }else{
            map.put(key, value); // 否则新添加新的key
            size++;

            if(size >= upperTol * M && capacityIndex + 1 < capacity.length){ // 超过上限，进行扩容
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
        }
    }

    // 删
    public V remove(K key){
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;
        if(map.containsKey(key)){
            ret = map.remove(key);
            size--;

            if(size <= lowerTol * M && capacityIndex - 1 >= 0){ // 小于下限，进行缩容
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }
        return ret;
    }

    // 改
    public void set(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(!map.containsKey(key)){
            throw new IllegalArgumentException(key + "doesn't exist");
        }
        map.put(key, value);
    }

    // 查
    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);
    }
    // 另一种查的方式
    public V get(K key){
        return hashtable[hash(key)].get(key);
    }

    private void resize(int newM){
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for(int i = 0; i < newM; i++){
            newHashTable[i] = new TreeMap<>();
        }

        // 将原数组内容复制到新的数组内容里面去
        int oldM = M;
        this.M = newM; // 注意更新M
        for(int i = 0; i < oldM; i++){
            TreeMap<K, V> map = hashtable[i];
            for(K key : map.keySet()){
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }

        this.hashtable = newHashTable;
    }
}
