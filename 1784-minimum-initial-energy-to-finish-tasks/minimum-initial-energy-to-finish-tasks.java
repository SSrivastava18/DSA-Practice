class Solution {
    public int minimumEffort(int[][] tasks) {

        Arrays.sort(tasks, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });

        int ans = 0;
        int energy = 0;

        for (int[] task : tasks) {

            int actual = task[0];
            int minimum = task[1];

            if (energy < minimum) {

                int extra = minimum - energy;

                ans += extra;
                energy += extra;
            }

            energy -= actual;
        }

        return ans;
    }
}