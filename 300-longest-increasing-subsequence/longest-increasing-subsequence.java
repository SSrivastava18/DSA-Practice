class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i = 1; i<n; i++){
            if(nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
            }else{
                int idx =  lowerBound(list,nums[i]);
                list.set(idx,nums[i]);
            }
        }
        return list.size();
        
    }
    public int lowerBound(ArrayList<Integer> list, int target){
        int left = 0, right = list.size()-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(list.get(mid) >= target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}