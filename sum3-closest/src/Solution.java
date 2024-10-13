import java.util.Arrays;

class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        int closestToTarget = 10000000;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            int sum = 0;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    closestToTarget = sum;
                    break;
                }
                if (Math.abs(target - closestToTarget) > Math.abs(target - sum)) {
                    closestToTarget = sum;
                }
                if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return closestToTarget;
    }

    public static void main(String[] args) {
        threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
    }
}