import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(int num : nums){
            bst.add(num);
        }
/*
形成的结构：
        5
       / \
      3   6
     / \   \
    2   4    8
*/
        bst.preOrder();
        System.out.println();

        bst.preOrderNR();

        System.out.println(bst);

        bst.inOrder();

        // 测试removeMin和removeMax方法
        BST<Integer> bst1 = new BST<>();
        Random random = new Random();
        int n = 1000;
        for(int i = 0; i < n; i++){
            bst1.add(random.nextInt(10000));
        }
        ArrayList<Integer> num = new ArrayList<>();
        while(!bst1.isEmpty()){
            num.add(bst1.removeMin());
        }
        System.out.println(num);
        for(int i = 1; i < num.size(); i++){
            if(num.get(i - 1) > num.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Complete");

    }
}
