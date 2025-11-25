class Solution {
    public int smallestRepunitDivByK(int k) {

        if(k == 2 || k == 5)return -1;
        HashSet<Integer>set = new HashSet<>();

        int curr = 1;
        int len = 1;


        boolean flag = true;

        while(flag){
            int rem = curr%k;
            if(rem == 0)return len;
            else{
                curr = (rem*10)+1;
                len++;
                if(set.contains(rem))return -1;
                set.add(rem);
            }
        }

        return -1;

    }
}