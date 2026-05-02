class Solution {
    public int lastRemaining(int n) {
        return helper(1,1, n, true);
        
    }
    public static int helper(int head, int step, int rem, boolean left){
        if(rem == 1){
            return head;
        }
        if(left || rem%2 == 1){
            head = head+step;
        }
        rem =  rem/2;
        step= step*2;
        return helper(head, step, rem, !left);
    }
}