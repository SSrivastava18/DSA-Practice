class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];

        int idx;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        TrieNode root = new TrieNode();

        int bestIdx = 0;

        for (int i = 1; i < wordsContainer.length; i++) {
            if (wordsContainer[i].length() < wordsContainer[bestIdx].length()) {
                bestIdx = i;
            }
        }

        root.idx = bestIdx;

        for (int i = 0; i < wordsContainer.length; i++) {
            insert(root, wordsContainer[i], i, wordsContainer);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(root, wordsQuery[i]);
        }

        return ans;
    }

    private void insert(TrieNode root, String word, int index, String[] wordsContainer) {

        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {

            int c = word.charAt(i) - 'a';

            if (node.child[c] == null) {
                node.child[c] = new TrieNode();

                node.child[c].idx = index;
            } else {

                int oldIdx = node.child[c].idx;

                if (wordsContainer[index].length() <
                    wordsContainer[oldIdx].length()) {

                    node.child[c].idx = index;
                }
            }

            node = node.child[c];
        }
    }

    private int search(TrieNode root, String query) {

        TrieNode node = root;

        for (int i = query.length() - 1; i >= 0; i--) {

            int c = query.charAt(i) - 'a';

            if (node.child[c] == null) {
                break;
            }

            node = node.child[c];
        }

        return node.idx;
    }
}