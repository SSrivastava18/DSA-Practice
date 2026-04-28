class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                list.add(grid[i][j]);
            }
        }

        int rem = list.get(0) % x;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % x != rem) {
                return -1;
            }
        }

        Collections.sort(list);

        int median = list.get(list.size() / 2);

        int operations = 0;

        for (int i = 0; i < list.size(); i++) {
            operations += Math.abs(list.get(i) - median) / x;
        }

        return operations;
    }
}