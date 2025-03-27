// LeetCode: Minimum Genetic Mutation (minimum-genetic-mutation)
// Submission ID: 1588412519
// Language: java
// Timestamp (UTC): 2025-03-27T17:54:40Z

class Solution {
     static char arr[] = {'A', 'T', 'G', 'C'};

    public static int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(endGene)) return -1;

        Queue<String> q = new LinkedList<>();
        q.add(startGene);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String str = q.poll();
                if (str.equals(endGene)) return level;

                char[] tempArr = str.toCharArray();
                for (int i = 0; i < tempArr.length; i++) {
                    char original = tempArr[i];
                    for (char ch : arr) {
                        if (ch != original) {
                            tempArr[i] = ch;
                            String mutated = new String(tempArr);
                            if (set.contains(mutated)) {
                                q.add(mutated);
                                set.remove(mutated); // Remove to prevent cycles
                            }
                        }
                    }
                    tempArr[i] = original; // Restore original character
                }
            }
            level++;
        }
        return -1;
    }
}