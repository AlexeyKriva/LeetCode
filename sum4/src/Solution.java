import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return getFourSum(4, target, 0, nums, new ArrayList<>());
    }

    public static List<List<Integer>> getFourSum(int k, long target, int start,
                                                 int[] nums, List<List<Integer>> fours) {
        if (start + k > nums.length) {
            return fours;
        }
        if (k > 2) {
            for (int i = start; i < nums.length - k + 1; i++) {
                int preSize = fours.size();
                getFourSum(k - 1, target - nums[i], i + 1, nums, fours);
                for (int j = preSize; j < fours.size(); j++) {
                    fours.get(j).add(nums[i]);
                }
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        } else {
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] < target) {
                    start++;
                } else if (nums[start] + nums[end] > target) {
                    end--;
                } else {
                    fours.add(new ArrayList<>(Arrays.asList(nums[start], nums[end])));
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    start++;
                    end--;
                }
            }
            return fours;
        }
        return fours;
    }

    public static void main(String[] args) {
        fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }
}