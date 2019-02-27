import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> word1 = new ArrayList<>();
        FileOperation.readFile("E:\\Data-Structure\\Set\\src\\pride-and-prejudice.txt", word1);
        System.out.println("Total words:" + word1.size());

        BSTSet<String> set1 =  new BSTSet<>();
        for(String word : word1){
            set1.add(word);
        }
        System.out.println("Total different words:" + set1.getSize());

        System.out.println("####分割线####");

        System.out.println("A Tale Of Two Cities");
        ArrayList<String> word2 = new ArrayList<>();
        FileOperation.readFile("E:\\Data-Structure\\Set\\src\\a-tale-of-two-cities.txt", word2);
        System.out.println("Total words:" + word2.size());

        LinkedListSet<String> set2 = new LinkedListSet<>();
        for(String word : word2){
            set2.add(word);
        }
        System.out.println("Total different words:" + set2.getSize());


    }
}
