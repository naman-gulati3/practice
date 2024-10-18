package com.practice.dsa.bit_manipulation;

class NumberOfMaxBitWiseOr {
    private int max = 0;
    public int countMaxOrSubsets(int[] nums) {
        for(int num : nums) {
            max |= num;
        }

        int[] count = new int[1];
        findSubsets(nums, count, max, 0, 0);
        return count[0];
    }

    private void findSubsets(int[] nums, int[] count, int max, int currentOr, int i) {
        if(currentOr == max) {
            count[0]++;
        }

        for(int idx = i; idx < nums.length; idx++) {
            findSubsets(nums, count, max, currentOr | nums[idx], idx + 1);
        }
    }
}