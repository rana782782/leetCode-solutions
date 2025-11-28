class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int count = 0;

        for(int i =0; i<hours.length; i++){
            int first = hours[i];

            for(int j = i+1; j<hours.length; j++){
                int sec = hours[j];

                if((first+sec)%24 == 0)count++;
            }
        }

        return count;
    }
}