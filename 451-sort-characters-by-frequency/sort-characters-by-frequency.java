class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        List<List<Character>> list = new ArrayList<>();
        
        for (int i = 0; i <= s.length(); i++) {
            list.add(new ArrayList<>());
        }

        for (char ch : map.keySet()) {
            int freq = map.get(ch);
            list.get(freq).add(ch);
        }

       StringBuilder sb = new StringBuilder();

        for (int i = list.size() - 1; i >= 0; i--) {
            for (char ch : list.get(i)) {
                for (int j = 0; j < i; j++) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}