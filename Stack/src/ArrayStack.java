// 基于"不要小瞧数组"课程中的动态数组创建的Stack
public class ArrayStack<E> implements Stack {
    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity); // 传入指定容量
    }

    public ArrayStack() {
        array = new Array<>();  // 使用默认的容量
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(Object o) {
        array.addLast((E)o);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for(int i = 0; i < array.getSize(); i++){
            res.append(array.get(i));
            if(i != array.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
