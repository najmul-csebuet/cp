package Leetcode.Interview.Easy.Array;

public class RemoveDuplicates {
    public static void main(String[] args) {
        var s = new RemoveDuplicates();
        s.removeDuplicates(new int[]{1, 1, 2});
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        // 1 1 1 2 2 3 3
        // 1 2 3
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }

        return j + 1;
    }
}

