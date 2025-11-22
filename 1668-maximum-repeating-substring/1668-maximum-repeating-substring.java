class Solution {
    public int maxRepeating(String sequence, String word) {
        StringBuilder temp = new StringBuilder(word);

        int count = 0;

        while(temp.length()<=sequence.length()){
            if(sequence.contains(temp.toString())){
                count++;
                temp.append(word);
            }
            else{
                break;
            }
        }

        return count;
    }
}