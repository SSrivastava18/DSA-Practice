class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int j = 0; j < ransomNote.length(); j++) {
            char ch = ransomNote.charAt(j);

            if (!map.containsKey(ch)) {
                return false;
            }
            if(map.get(ch) == 0){
                return false;
            }

            map.put(ch, map.get(ch) - 1);
        }

        return true;
    }
}