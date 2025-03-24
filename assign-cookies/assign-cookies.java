// LeetCode: Assign Cookies (assign-cookies)
// Submission ID: 1584446707
// Language: java
// Timestamp (UTC): 2025-03-24T14:01:23Z

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int ans = 0;

        int i = 0; int j = 0;

        while(i<g.length && j<s.length){
            if(s[j]>=g[i]){
                ans++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        return ans;
    }
}