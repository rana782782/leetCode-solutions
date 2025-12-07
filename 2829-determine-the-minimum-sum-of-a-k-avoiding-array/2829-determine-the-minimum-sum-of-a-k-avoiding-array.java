class Solution {
    public int minimumSum(int n, int k) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        int num = 1;

        while (set.size() < n) {
            if (!set.contains(k - num)) {
                set.add(num);
                sum += num;
            }
            num++;
        }
        return sum;
    }
}
