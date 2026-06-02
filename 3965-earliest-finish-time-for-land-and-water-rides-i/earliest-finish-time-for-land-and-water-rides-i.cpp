class Solution {
public:
    int earliestFinishTime(vector<int>& landStartTime,
                           vector<int>& landDuration,
                           vector<int>& waterStartTime,
                           vector<int>& waterDuration) {
        
        int ans = INT_MAX;
        
        int n = landStartTime.size();
        int m = waterStartTime.size();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                int finish1 = max(waterStartTime[j],
                                  landStartTime[i] + landDuration[i])
                              + waterDuration[j];
                
                int finish2 = max(landStartTime[i],
                                  waterStartTime[j] + waterDuration[j])
                              + landDuration[i];
                
                ans = min(ans, min(finish1, finish2));
            }
        }
        
        return ans;
    }
};