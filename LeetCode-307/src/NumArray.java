public class NumArray {
    private SegmentTree<Integer> segmentTree;
    public NumArray(int[] nums){
        if(nums.length > 0){
            Integer[] data = new Integer[nums.length];
            for(int i = 0; i < nums.length; i++){
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public void update(int index, int val){
        if(segmentTree == null){
            throw new IllegalArgumentException("Segment Tree is null");
        }

        segmentTree.set(index, val);
    }

    public int sumRange(int i, int j){
        if(segmentTree == null){
            throw new IllegalArgumentException("Segment Tree is null");
        }
        return segmentTree.query(i, j);
    }
}
