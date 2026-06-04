class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for(int i = num1; i<=num2; i++){
            ans += waviness(i);
        }
        return ans;
        
    }
    public int waviness(int i){
        String s = String.valueOf(i);

        int count = 0;
        if(s.length()<3) return 0;
        for(int j = 1; j<s.length()-1; j++){
            int prev = s.charAt(j-1)-'0';
            int curr = s.charAt(j)-'0';
            int next = s.charAt(j+1) - '0';

            if((curr>prev && next<curr)|| curr<prev && curr<next){
                count++;
            }

           


        }
         return count;
    }
}