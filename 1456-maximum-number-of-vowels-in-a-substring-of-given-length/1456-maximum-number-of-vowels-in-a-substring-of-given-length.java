class Solution {
    public int maxVowels(String s, int k) {
        List<Character> list=new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        int length=0;
        int i=0;
        while(i<k){
            if(list.contains(s.charAt(i))){
                length++;
            }
            i++;
        }
        int left=0;
        int right=k;
        int maxLen=length;
        while(right<s.length()){
            if(list.contains(s.charAt(right))){
                length++;
            }
            if(list.contains(s.charAt(left))){
                length--;
            }
            maxLen=Math.max(maxLen,length);
            left++;
            right++;
        }
        return maxLen;
    }
}