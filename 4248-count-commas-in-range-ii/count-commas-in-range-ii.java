class Solution {
    public long countCommas(long n) {
        long count = 0;
        long value = 1000;
 
        while(value<=n){
            
            count += n-value+1;
            value*=1000;
            
            
        }
        return count;

    }
}