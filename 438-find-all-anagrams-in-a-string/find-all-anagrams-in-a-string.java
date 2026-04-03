class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if (s.length() < p.length()) return result;
        
        int[] countP = new int[26];
        int[] countS = new int[26];
        
        for (char c : p.toCharArray()) {
            countP[c - 'a']++;
        }
        
        int k = p.length();
        
        for (int i = 0; i < k; i++) {
            countS[s.charAt(i) - 'a']++;
        }
        
        if (Arrays.equals(countP, countS)) {
            result.add(0);
        }
        
        for (int i = k; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            
            countS[s.charAt(i - k) - 'a']--;
            
            
            if (Arrays.equals(countP, countS)) {
                result.add(i - k + 1);
            }
        }
        
        return result;
    }
}