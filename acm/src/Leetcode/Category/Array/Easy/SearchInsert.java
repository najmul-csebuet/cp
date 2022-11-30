package Leetcode.Category.Array.Easy;

/*
        1 2 3 --> target = 0, left = 0, right = 2, mid = 1, midValue = 2?
        1 --> target = 0, left = 0, right = 0, mid = 0, midValue = 1? stop here

        we are going to right
        new right is same to old right
        we have to return left?
*/


public class SearchInsert {

    public static void main(String[] args) {
        System.out.println(search(new int[] {1, 3, 5, 7}, 8) == 4);
        System.out.println(search(new int[] {1, 3, 5, 7}, 4) == 2);
        System.out.println(search(new int[] {1, 3, 5, 7}, 0) == 0);
    }

    public static int search(int[] nums, int target) {

        return getPosition(nums, target, 0, nums.length - 1);
    }

    private static int getPosition(int[] nums, int target, int left, int right) {

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        else if (target < nums[mid]) {
            if (left == right || left + 1 == right) return left;
            right = mid - 1;
        }
        else if (target > nums[mid]) {
            if (left == right) return right + 1;
            left = mid + 1;
        }

        return getPosition(nums, target, left, right);
    }
}

