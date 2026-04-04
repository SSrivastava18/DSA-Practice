class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) {
            return encodedText;
        }

        int n = encodedText.length();
        int cols = n / rows;
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < cols; j++) {
            int r = 0;
            int c = j;
            while (r < rows && c < cols) {
                sb.append(encodedText.charAt(r * cols + c));
                r++;
                c++;
            }
        }

        int last = sb.length() - 1;
        while (last >= 0 && sb.charAt(last) == ' ') {
            last--;
        }

        return sb.substring(0, last + 1);
    }
}