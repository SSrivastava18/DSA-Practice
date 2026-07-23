class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;
        for(int i = 0; i<nums.length; i++){
            right = Math.max(nums[i],right);
        }
        int ans = -1;
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(isPossible(nums,mid,threshold)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;

        
    }
    public static boolean isPossible(int[] nums, int divisor, int threshold){
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += (int) Math.ceil((double) nums[i] / divisor);
            
        }
        if(sum<=threshold){
            return true;
        }
        return false;
    }
}