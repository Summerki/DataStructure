import com.sun.deploy.security.WIExplorerUntrustedCertStore;

public class Array<E> {
    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
//        data = new E[capacity];// java还不支持这样的写法
        data = (E[]) new Object[capacity];// 得这样写
        size = 0;
    }

    // 无参构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    // 获取数组中元素的个数
    public int getSize(){
        return size;
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0; // 这个写法不错
    }

    // 向所有元素后添加一个新元素
    public void addLast(E e){
//        if(size == data.length){
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
//        }
//        data[size] = e;
//        size++;
        add(size, e); // 优化
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e){
        add(0, e);
    }

    // 在index位置插入一个新的元素e
    public void add(int index, E e){
        if(index < 0  || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
        }
        // 扩容
        if(size == data.length){
            resize(2 * data.length);
        }
        for(int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 获取index索引位置的元素
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    // 查询数组中是否有e
    public boolean contains(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引；如果不存在元素e则返回-1
    public int find(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){   // 这里不能再是 data[i] == e ；两个类对象比较得用equals
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素，返回被删除的元素
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E ret = data[index];
        for(int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;

        // 缩容
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }

    // 从数组中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素，返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for(int i = 0; i < size; i++){
            res.append(data[i]);
            if(i != size - 1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
