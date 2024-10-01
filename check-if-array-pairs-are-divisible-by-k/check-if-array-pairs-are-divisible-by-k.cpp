// LeetCode: Check If Array Pairs Are Divisible by k (check-if-array-pairs-are-divisible-by-k)
// Submission ID: 1408354565
// Language: cpp
// Timestamp (UTC): 2024-10-01T15:44:55Z

class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        unordered_map<int, int> remainderCount;

        for(int i = 0; i<arr.size(); i++){
            int remainder = (arr[i]%k + k)%k;
            remainderCount[remainder]++;
        }

        for(auto&[remainder, count] : remainderCount){
            if(remainder == 0){
                if(count%2 != 0){
                    return false;
                }
            }

            else{
                int compliment = k - remainder;
                if(remainderCount[compliment] != count){
                    return false;
                }
            }
        }

        return true;
    }
};