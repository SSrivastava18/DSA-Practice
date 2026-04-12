class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<expression.length();i++){
            char c = expression.charAt(i);
            if(c =='-'||c=='+'||c=='*'){
                String left = expression.substring(0,i);
                String right = expression.substring(i+1);
                List<Integer> leftans = diffWaysToCompute(left);
                List<Integer> rightans = diffWaysToCompute(right);
                for(int x : leftans){
                    for(int y: rightans){
                        if(c == '+'){
                            ans.add(x+y);
                        }else if(c == '-'){
                            ans.add(x-y);
                        }else{
                            ans.add(x*y);
                        }
                    }
                }


            }
        }
        if (ans.size() == 0) ans.add(Integer.parseInt(expression));
        return ans;

        
    }
}