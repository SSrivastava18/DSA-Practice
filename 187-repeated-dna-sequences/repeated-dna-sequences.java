class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        String curr = "";

        int i = 0, j = 0;
        int n = s.length();

        while (j < n) {
            curr += s.charAt(j); 

            if (j - i + 1 == 10) {
                if (map.getOrDefault(curr, 0) == 1) {
                    ans.add(curr); 
                }
                map.put(curr, map.getOrDefault(curr, 0) + 1);
                
                curr = curr.substring(1);
                i++;
            }

            j++;
        }

        return ans;
        
    }
}