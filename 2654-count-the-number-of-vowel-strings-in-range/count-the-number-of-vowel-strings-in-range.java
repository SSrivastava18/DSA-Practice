class Solution {

    public int vowelStrings(String[] words, int left, int right) {

        int count = 0;

        for (int i = left; i <= right; i++) {

            String s = words[i];

            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);

            if (isVowel(first) && isVowel(last)) {
                count++;
            }
        }

        return count;
    }

    public boolean isVowel(char ch) {

        return ch == 'a' || ch == 'e' || ch == 'i'
            || ch == 'o' || ch == 'u';
    }
}