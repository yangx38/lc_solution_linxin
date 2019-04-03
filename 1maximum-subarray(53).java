class Solution {
    // subSum = curSum - prefixSum 
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int curSum = 0, prefixSum = 0;
        int subSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            subSum = Math.max(curSum-prefixSum, subSum);
            prefixSum = Math.min(curSum, prefixSum);
        }
        return subSum;
    }
}