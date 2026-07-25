class Solution {

    List<Integer>[] tree;
    int ans = 0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        tree = new ArrayList[n];

        for(int i=0;i<n;i++)
            tree[i] = new ArrayList<>();

        for(int i=0;i<n;i++){

            if(manager[i] != -1)
                tree[manager[i]].add(i);

        }

        dfs(headID,0,informTime);

        return ans;
    }

    void dfs(int node,int time,int[] informTime){

        ans = Math.max(ans,time);

        for(int child : tree[node]){

            dfs(child,time + informTime[node],informTime);

        }
    }
}