// LeetCode: Boats to Save People (boats-to-save-people)
// Submission ID: 1767016238
// Language: java
// Timestamp (UTC): 2025-09-11T09:49:51Z

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;

        int low = 0;
        int high = people.length-1;

        while(low<=high){
            int weight = people[low]+people[high];

            if(low == high){
                if(people[low]<=limit){
                    count++;
                }
                low++;
            }

            else if(weight <= limit){
                count++;
                low++;
                high--;
            }

            else if(weight>limit){
                if(people[high]<=limit){
                    count++;
                }
                high--;
            }
      
        }
        return count;
    }
}