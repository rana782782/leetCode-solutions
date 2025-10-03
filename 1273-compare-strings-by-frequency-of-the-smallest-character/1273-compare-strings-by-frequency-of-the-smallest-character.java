class Solution {
    public static int getFreq(String str){
        TreeMap<Character,Integer>map = new TreeMap<>();
        for(char ch : str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        return map.get(map.firstKey());
    }
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int output[] = new int[queries.length];
        TreeMap<Integer,Integer>map = new TreeMap<>();
        for(String str : words){
            int freq = getFreq(str);
            
            map.put(freq,map.getOrDefault(freq,0)+1);
        }
        int idx = 0;
        for(String str : queries){
            int freq = getFreq(str);
            int sum = 0;
            for(int key : map.keySet()){
                if(freq<key)sum+=map.get(key);
                

            }
            output[idx++] = sum;

        }

        return output;

    }
}