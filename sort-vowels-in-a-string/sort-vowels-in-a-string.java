// LeetCode: Sort Vowels in a String (sort-vowels-in-a-string)
// Submission ID: 1767003335
// Language: java
// Timestamp (UTC): 2025-09-11T09:34:47Z

class Solution {

    public static boolean isVowel(Character ch){
        char chr = Character.toLowerCase(ch);

        if(chr == 'a' || chr =='e' || chr=='i' || chr == 'o' || chr == 'u')return true;

        return false;
    }
    public String sortVowels(String s) {
        HashSet<Integer>set = new HashSet<>();
        TreeMap<Integer,Integer>map = new TreeMap<>();

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                set.add(i);
                map.put((int)ch, map.getOrDefault((int)ch,0)+1);
            }
        }

        StringBuilder output = new StringBuilder();

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(set.contains(i)){
                set.remove(i);
                int code = map.firstKey();
                char ins = (char)code;
                System.out.print(ins+"_");
                output.append(ins);
                map.put(code,map.get(code)-1);
                if(map.get(code) == 0)map.remove(code);
            }
            else{
                System.out.print(ch+"_");
                output.append(ch);
            }
        }

        return output.toString();

    }
}