class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            setA.add(A[i]);
            setB.add(B[i]);

            int count = 0;

            for (int num : setA) {
                if (setB.contains(num)) {
                    count++;
                }
            }

            ans[i] = count;
        }

        return ans;
    }
}