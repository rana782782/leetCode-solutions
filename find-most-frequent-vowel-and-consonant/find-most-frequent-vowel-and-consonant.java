// LeetCode: Find Most Frequent Vowel and Consonant (find-most-frequent-vowel-and-consonant)
// Submission ID: 1769051334
// Language: java
// Timestamp (UTC): 2025-09-13T08:17:05Z

class Solution {

    public static boolean isVowel(Character ch){
        if(ch == 'a' || ch == 'e' || ch =='i' || ch == 'o' || ch == 'u')return true;
        return false;
    }
    public int maxFreqSum(String s) {
        HashMap<Character,Integer>map1 = new HashMap<>();
        HashMap<Character,Integer>map2 = new HashMap<>();

        for(char ch : s.toCharArray()){
            if(isVowel(ch))map1.put(ch,map1.getOrDefault(ch,0)+1);
            else{
                map2.put(ch,map2.getOrDefault(ch,0)+1);
            }
        }


        int vFreq = 0;
        int cFreq = 0;

        for(int val : map1.values()){
            vFreq = Math.max(vFreq,val);
        }

         for(int val : map2.values()){
            cFreq = Math.max(cFreq,val);
        }

        return vFreq+cFreq;
    }
}