// LeetCode: Sliding Puzzle (sliding-puzzle)
// Submission ID: 1471890697
// Language: java
// Timestamp (UTC): 2024-12-06T14:17:11Z

class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder orgState = new StringBuilder();
        String fState = "123450";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                orgState.append(board[i][j]);
            }
        }

        if (orgState.toString().equals(fState)) {
            return 0;
        }

        HashSet<String> visited = new HashSet<>();
        visited.add(orgState.toString());

        ArrayList<Integer>[] moves = new ArrayList[6];
        for (int i = 0; i < moves.length; i++) {
            moves[i] = new ArrayList<>();
        }
        moves[0].addAll(Arrays.asList(1, 3));
        moves[1].addAll(Arrays.asList(0, 2, 4));
        moves[2].addAll(Arrays.asList(1, 5));
        moves[3].addAll(Arrays.asList(0, 4));
        moves[4].addAll(Arrays.asList(1, 3, 5));
        moves[5].addAll(Arrays.asList(2, 4));

        Queue<String> q = new LinkedList<>();
        q.add(orgState.toString());
        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            count++;

            for (int i = 0; i < size; i++) {
                String rem = q.poll();
                int zeroIdx = rem.indexOf('0');

                for (int idx : moves[zeroIdx]) {
                    String swapped = swap(rem, idx, zeroIdx);

                    if (!visited.contains(swapped)) {
                        if (swapped.equals(fState)) {
                            return count;
                        }
                        q.add(swapped);
                        visited.add(swapped);
                    }
                }
            }
        }
        return -1;
    }

    public static String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}