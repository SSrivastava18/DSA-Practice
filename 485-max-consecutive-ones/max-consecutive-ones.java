class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currCount = 0;
        int maxCount = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1){
                currCount++;
                maxCount = Math.max(currCount, maxCount);
            }else{
                currCount = 0;
            }
        }
        return maxCount;
        
    }
}