class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> s = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();

        for(int i = 0; i<nums1.length; i++){
            s.add(nums1[i]);
        }
        for(int i = 0; i<nums2.length;i++){
            if(s.contains(nums2[i])){
                ans.add(nums2[i]);
            }
        }
        int[] answer = new int[ans.size()];
        int index = 0;

        for (int num : ans) {
            answer[index++] = num;
        }
        return answer; 
        
    }
}