import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

// leetcode347题
public class Solution {

    private class Freq implements Comparable<Freq>{
        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            // 由于我们课程实现的是最大堆，但是leetcode这道题用最小堆来做
            // 所以这里我们定义频次越低优先级越高
            if(this.freq < another.freq){
                return 1;
            }else if(this.freq > another.freq){
                return -1;
            }else{
                return 0;
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        // 使用map来统计频次；前一个int表示数据，后一个int表示频次
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<Freq>();
        for(int key : map.keySet()){
            if(pq.getSize() < k){
                pq.enqueue(new Freq(key, map.get(key)));
            }else if(map.get(key) > pq.getFront().freq){
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()){
            res.add(pq.dequeue().e);
        }
        return res;
    }
}
